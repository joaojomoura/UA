#include <detpic32.h>
#include "../prog4/configUART.c"
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

void puts(char *str){
  while(*str != '\0'){
    putc(*str);
    str++;
  }
}

int main (void){
  //UART configuration
  configUART(115200,'E',2);
  while(1){
    puts("String de teste\n");
    delay(1000);
  }
  return 0;
}
