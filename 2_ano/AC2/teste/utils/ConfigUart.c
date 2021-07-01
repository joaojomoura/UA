void configUart (unsigned int baud, char parity, unsigned int stopbits){
  
  if(baud < 600 || baud > 115200)
    baud = 115200;
  U2BRG = ((PBCLK + 8 * baud)/ (16 * baud)) - 1;
  U2MODEbits.BRGH = 0;

  switch(parity){
    case ('N'):
      U2MODEbits.PDSEL = 0;
      break;
    case ('E'):
      U2MODEbits.PDSEL = 1;
      break;
    case ('O'):
      U2MODEbits.PDSEL = 2;
      break;
    default:
      U2MODEbits.PDSEL = 0;
      break;
  }
 if(stopbits == 2)
   U2MODEbits.STSEL = 1;
 else
   U2MODEbits.STSEL = 0;

  U2STAbits.UTXEN = 1;
  U2STAbits.URXEN = 1;
  U2MODEbits.ON = 1;
}
