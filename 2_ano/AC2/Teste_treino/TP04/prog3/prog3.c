#include <detpic32.h>
#include "../delay.c"

int main(void){
  LATB = LATB & 0x00FF;   //configuracao a 0 inicial
  LATD = LATD & 0xFF9F;

  TRISB = TRISB & 0x00FF; // configurar como saida (output)
  TRISD = TRISD & 0xFF9F;
  
  LATDbits.LATD5 = 1;
  LATDbits.LATD6 = 0;

  while(1){
    char c = getChar();

    switch(c){
      case 'a':
        LATB = LATB & 0x00FF;
        LATBbits.LATB8 = 1;
        break;
      case 'b':
        LATB = LATB & 0x00FF;
        LATBbits.LATB9 = 1;
        break;
      case 'c':
        LATB = LATB & 0x00FF;
        LATBbits.LATB10 = 1;
        break;
      case 'd':
        LATB = LATB & 0x00FF;
        LATBbits.LATB11 = 1;
        break;
      case 'e':
        LATB = LATB & 0x00FF;
        LATBbits.LATB12 = 1;
        break;
      case 'f':
        LATB = LATB & 0x00FF;
        LATBbits.LATB13 = 1;
        break;
      case 'g':
        LATB = LATB & 0x00FF;
        LATBbits.LATB14 = 1;
        break;
      default:
        LATB = LATB & 0x00FF;
        break;
    }
  }
  return 0;

}
