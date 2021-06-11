#include <detpic32.h>

void delay(int ms)
{
    for(;ms>0;ms--)
    {
        resetCoreTimer();
        while(readCoreTimer()<20000);
    }
}


void putc(char byte2send){
  while(U2STAbits.UTXBF == 1);                    //wait while UTXBF==1
  U2TXREG = byte2send;
}

int main (void){
  //UART configuration
  U2BRG = ((PBCLK + 8*115200)/(16*115200))-1;     //constant U1BRG, baudrate = 115200
  U2MODEbits.BRGH = 0;                            //16x baud clock enabled
  U2MODEbits.PDSEL = 0;                           //8bits, no parity
  U2MODEbits.STSEL = 0;                           //1 stop bit
  U2STAbits.UTXEN = 1;                            //UART transmiter is enabled
  U2STAbits.URXEN = 1;                            //UART receiver is enabled
  U2MODEbits.ON = 1;                              //UART enabled

  while(1){
    putc('+');
    delay(1000);
  }
  return 0;
}
