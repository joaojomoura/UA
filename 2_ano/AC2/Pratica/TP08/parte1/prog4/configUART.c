#include <detpic32.h>

void configUART(unsigned int baud, char parity, unsigned int stopbits){
  //default baud
  if(baud < 600 || baud > 115200)
    baud = 115200;

  U2BRG = ((PBCLK + 8*baud)/(16*baud))-1;     //constant U1BRG, baudrate = 115200
  U2MODEbits.BRGH = 0;                            //16x baud clock enabled

  //parity define
  switch (parity){
    case ('N'):
      U2MODEbits.PDSEL = 0;                           //8bits, no parity
      break;
    case ('E'):
      U2MODEbits.PDSEL = 1;                           //8bits, even parity
      break;
    case ('O'):
      U2MODEbits.PDSEL = 2;                           //8bits, odd parity
      break;
    default:
      U2MODEbits.PDSEL = 0;                           //8bits, no parity
      
  }

  //stopbits define
  switch (stopbits) {
    case 2 :
      U2MODEbits.STSEL = 1;                           //1 stop bit
      break;
    case 1 :
      U2MODEbits.STSEL = 0;                           //1 stop bit
      break;

    default:  
      U2MODEbits.STSEL = 0;                           //1 stop bit
      
  }

  U2STAbits.UTXEN = 1;                            //UART transmiter is enabled
  U2STAbits.URXEN = 1;                            //UART receiver is enabled
  U2MODEbits.ON = 1;                              //UART enabled
}
