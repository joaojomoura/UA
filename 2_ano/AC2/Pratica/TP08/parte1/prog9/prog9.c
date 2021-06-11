#include <detpic32.h>
#include "../prog4/configUART.c"

void putc(char byte2send){
  while(U2STAbits.UTXBF == 1);                    //wait while UTXBF==1
  U2TXREG = byte2send;
}

char getc(void){
  if(U2STAbits.OERR == 1) U2STAbits.OERR = 0;

  while(U2STAbits.URXDA == 0);

  if(U2STAbits.FERR || U2STAbits.PERR){
    char a = U2RXREG;
    return 0;
  }

  return U2RXREG;
}


int main(void){
  configUART(115200,'N',1);
  while(1){
    putc(getc());
  }
}
