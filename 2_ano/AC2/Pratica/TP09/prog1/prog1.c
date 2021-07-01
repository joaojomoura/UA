#include <detpic32.h>
#include "../configUART.c"

#define DisableUart2RxInterrupt() IEC1bits.U2RXIE = 0 
#define EnableUart2RxInterrupt()  IEC1bits.U2RXIE = 1
#define DisableUart2TxInterrupt() IEC1bits.U2TXIE = 0 
#define EnableUart2TxInterrupt()  IEC1bits.U2TXIE = 1
#define BUF_SIZE 8
#define INDEX_MASK (BUF_SIZE - 1)

typedef struct {
  unsigned char data[BUF_SIZE];
  unsigned int head;
  unsigned int tail;
  unsigned int count;
}circularBuffer;


volatile circularBuffer txb;    //Transmission Buffer
volatile circularBuffer rxb;    //Reception  Buffer

void comDrv_flushRx (void){
 rxb.count = 0;
 rxb.head = 0;
 rxb.tail = 0;
}

void comDrv_flushTx (void){
 txb.count = 0;
 txb.head = 0;
 txb.tail = 0; 
}



void comDrv_putc(char ch) {
  while(txb.count == BUF_SIZE){}  //wait while buffer is full
  txb.data[txb.tail] = ch;        //Copy character to the Transmission
                                  // buffer at position tail
  txb.tail = (txb.tail + 1) & INDEX_MASK; //Increment tail index (mod. BUF_SIZE)
  DisableUart2TxInterrupt();       // Begin of critical section 
  txb.count++;
  EnableUart2TxInterrupt();       // Begin of critical section 
}

void comDrv_puts(char *s){
  while(*s != '\0'){
    comDrv_putc(*s);
    s++;
  }
  comDrv_putc('\0');
}


void _int_(32) isr_uart2(void){
  if(IFS1bits.U2TXIF){
    if(txb.count > 0){
      U2TXREG = txb.data[txb.head];
      txb.head = (txb.head + 1) & INDEX_MASK;
      txb.count--;
    }
    if(txb.count == 0)
      DisableUart2TxInterrupt();
    IFS1bits.U2TXIF = 0;
  }
  if(IFS1bits.U2RXIF){
    rxb.data[rxb.tail] = U2RXREG;
    rxb.tail = (rxb.tail + 1) & INDEX_MASK;
    if(rxb.count < BUF_SIZE)
      rxb.count++;
    else
      rxb.head = (rxb.head + 1) & INDEX_MASK;
    IFS1bits.U2RXIF = 0;
  }
}

char comDrv_getc(char *pchar){
  if(rxb.count == 0)                      //the buffer is empty
        return 0;
    DisableUart2RxInterrupt();             //Begining of critical section
    *pchar = rxb.data[rxb.head];            //copy character pointed by "head" to *pchar
    rxb.count--;                            //decrement count variable
    rxb.head = (rxb.head + 1) & INDEX_MASK; //increment "head" index (mod BUF_SIZE)
    EnableUart2RxInterrupt();              //end of critical section
    return 1;
}



int main (void){

  configUART(115200,'N',1);
  /* U2STAbits.URXISEL0 = 0; */
  // U2STAbits.URXISEL1 = 0;
  //
  // U2STAbits.UTXISEL0 = 0;
  // U2STAbits.UTXISEL1 = 0;
/*  */
  IEC1bits.U2RXIE = 1;
  IEC1bits.U2TXIE = 1;
  IEC1bits.U2EIE = 1;

  IPC8bits.U2IP = 2;
  IPC8bits.U2IS = 2;


  comDrv_flushRx();
  comDrv_flushTx();
  EnableInterrupts();
  /* while(1) */
    /* comDrv_puts("Teste do bloco de transmissao do device driver!..."); */
  comDrv_puts("PIC32 UART Device-driver\n");
  while(1){
    char c;
    
    if(comDrv_getc(&c)){
      if(c == 'S')
        comDrv_puts("Hello atomic_uint_fast16_tster!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
      comDrv_putc(c);
    }
  }
}
