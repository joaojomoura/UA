void putc(char byte2send){
  while(U2STAbits.UTXBF == 1);
  U2TXREG = byte2send;
}
