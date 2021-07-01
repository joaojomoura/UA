#include "../../utils/utils.h"
#include "../../utils/bufferUart.h"
volatile circularBuffer txb;
volatile circularBuffer rxb;
int main(void){
  configUart(115200,'N',1);
  comDrv_flushRx();
  comDrv_flushTx();
  IPC8bits.U2IP = 2;
  IF1S0bits.U2RXIF = 0;
  IF1S0bits.U2TXIF = 0;
  EnableUart2RxInterrupt();
  DisableUart2TxInterrupt();
  EnableInterrupts();

  comDrv_puts("PIC32 UART Device-driver\n");
  while(1){
    char c;
    
    if(comDrv_getc(&c)){
      if(c == 'S')
        comDrv_puts("Hello atomic_uint_fast16_tster!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
      comDrv_putc(c);
    }
}
