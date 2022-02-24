#include "thread.h"
#include <cstddef>
#include <stdio.h>
#include <unistd.h>

void *thread_main(void *args) {

  for (int i = 1; i < 10; i++) {
    printf("%3d\n", i);
    usleep(1000000);
  }
  return NULL;
}

void *thread_write_string(void *args) {
  printf("hey master\n");
  return NULL;
}

int main(int argc, char *argv[]) {
  pthread_t my_thread;
  pthread_t my_thread1;

  thread_create(&my_thread, NULL, &thread_main, NULL);
  thread_create(&my_thread1, NULL, &thread_write_string, NULL);

  thread_join(my_thread, NULL);
  thread_join(my_thread1, NULL);

  return 0;
}
