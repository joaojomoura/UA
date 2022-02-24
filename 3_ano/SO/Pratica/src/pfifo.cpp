#include "pfifo.h"
#include "include/thread.h"
#include <cstddef>
#include <dbc.h>
#include <string.h>

#include "thread.h"
//#include "process.h"

/* changes may be required to this function */
void init_pfifo(PriorityFIFO *pfifo) {
  // Iniciar mutexs e conds
  mutex_init(&pfifo->acessCR, NULL);
  cond_init(&pfifo->fifoNotFull, NULL);
  cond_init(&pfifo->fifoNotEmpty, NULL);

  // Lock acess to critical zone
  mutex_lock(&pfifo->acessCR);
  require(pfifo != NULL,
          "NULL pointer to FIFO"); // a false value indicates a program error

  memset(pfifo->array, 0, sizeof(pfifo->array));
  pfifo->inp = pfifo->out = pfifo->cnt = pfifo->done = 0;

  // Signal the fifo is not full for all waiting threads
  // cond_broadcast(&pfifo->fifoNotFull);

  // unlock acess to critical zone
  mutex_unlock(&pfifo->acessCR);
}

/* --------------------------------------- */

int empty_pfifo(PriorityFIFO *pfifo) {
  require(pfifo != NULL,
          "NULL pointer to FIFO"); // a false value indicates a program error

  return pfifo->cnt == 0;
}

/* --------------------------------------- */

int full_pfifo(PriorityFIFO *pfifo) {
  require(pfifo != NULL,
          "NULL pointer to FIFO"); // a false value indicates a program error

  return pfifo->cnt == FIFO_MAXSIZE;
}

/* --------------------------------------- */

/* changes may be required to this function */
void insert_pfifo(PriorityFIFO *pfifo, uint32_t id, uint32_t priority) {
  // lock acess to critical zone
  mutex_lock(&pfifo->acessCR);
  require(pfifo != NULL,
          "NULL pointer to FIFO"); // a false value indicates a program error
  require(id <= MAX_ID,
          "invalid id"); // a false value indicates a program error
  require(priority > 0 && priority <= MAX_PRIORITY,
          "invalid priority value"); // a false value indicates a program error

  // printf("[insert_pfifo] value=%d, priority=%d, pfifo->inp=%d,
  // pfifo->out=%d\n", id, priority, pfifo->inp, pfifo->out);

  // wait while fifo is full
  while (full_pfifo(pfifo)) {
    cond_wait(&pfifo->fifoNotFull, &pfifo->acessCR);
  }
  require(
      !full_pfifo(pfifo),
      "full FIFO"); // in a shared fifo, it may not result from a program error!

  uint32_t idx = pfifo->inp;
  uint32_t prev = (idx + FIFO_MAXSIZE - 1) % FIFO_MAXSIZE;
  while ((idx != pfifo->out) && (pfifo->array[prev].priority > priority)) {
    // printf("[insert_pfifo] idx=%d, prev=%d\n", idx, prev);
    pfifo->array[idx] = pfifo->array[prev];
    idx = prev;
    prev = (idx + FIFO_MAXSIZE - 1) % FIFO_MAXSIZE;
  }
  // printf("[insert_pfifo] idx=%d, prev=%d\n", idx, prev);
  pfifo->array[idx].id = id;
  pfifo->array[idx].priority = priority;
  pfifo->inp = (pfifo->inp + 1) % FIFO_MAXSIZE;
  pfifo->cnt++;
  // printf("[insert_pfifo] pfifo->inp=%d, pfifo->out=%d\n", pfifo->inp,
  // pfifo->out);

  // Signal fifo is not empty for waiting threads
  cond_broadcast(&pfifo->fifoNotEmpty);
  // unlock acess to critical zone
  mutex_unlock(&pfifo->acessCR);
}

/* --------------------------------------- */

/* changes may be required to this function */
uint32_t retrieve_pfifo(PriorityFIFO *pfifo) {
  // Lock acess to critial zone
  mutex_lock(&pfifo->acessCR);
  require(pfifo != NULL,
          "NULL pointer to FIFO"); // a false value indicates a program error

  // while fifo is empty, wait
  while (empty_pfifo(pfifo)) {
    if (pfifo->done == 1) {
      mutex_unlock(&pfifo->acessCR);
      return 9999;
    }
    cond_wait(&pfifo->fifoNotEmpty, &pfifo->acessCR);
  }

  require(!empty_pfifo(pfifo), "empty FIFO"); // in a shared fifo, it may not
                                              // result from a program error!
  check_valid_id(pfifo->array[pfifo->out].id);
  check_valid_priority(pfifo->array[pfifo->out].priority);

  uint32_t result = pfifo->array[pfifo->out].id;
  pfifo->array[pfifo->out].id = INVALID_ID;
  pfifo->array[pfifo->out].priority = INVALID_PRIORITY;
  pfifo->out = (pfifo->out + 1) % FIFO_MAXSIZE;
  pfifo->cnt--;

  // update priority of all remaing elements (increase priority by one)
  uint32_t idx = pfifo->out;
  for (uint32_t i = 1; i <= pfifo->cnt; i++) {
    if (pfifo->array[idx].priority > 1 &&
        pfifo->array[idx].priority != INVALID_PRIORITY)
      pfifo->array[idx].priority--;
    idx = (idx + 1) % FIFO_MAXSIZE;
  }

  // signal all wainting threads that fifo is not full
  cond_broadcast(&pfifo->fifoNotFull);
  // unlock acess to critical zone
  mutex_unlock(&pfifo->acessCR);
  return result;
}

/* --------------------------------------- */

/* changes may be required to this function */
void print_pfifo(PriorityFIFO *pfifo) {

  // Lock acess to critical zone
  mutex_lock(&pfifo->acessCR);

  require(pfifo != NULL,
          "NULL pointer to FIFO"); // a false value indicates a program error

  uint32_t idx = pfifo->out;
  for (uint32_t i = 1; i <= pfifo->cnt; i++) {
    check_valid_id(pfifo->array[pfifo->out].id);
    check_valid_priority(pfifo->array[pfifo->out].priority);
    printf("[%02d] value = %d, priority = %d\n", i, pfifo->array[idx].id,
           pfifo->array[idx].priority);
    idx = (idx + 1) % FIFO_MAXSIZE;
  }

  // unlock acess to crtitical zone
  mutex_unlock(&pfifo->acessCR);
}

void done_pfifo(PriorityFIFO *pfifo) {
  // Lock acess
  mutex_lock(&pfifo->acessCR);

  pfifo->done = 1;

  // Awake all slepping threads to finish the simulation
  cond_broadcast(&pfifo->fifoNotEmpty);

  // Unlock acess
  mutex_unlock(&pfifo->acessCR);
}
