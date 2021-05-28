void send2displays(unsigned char value){
  static const char display7Scodes [] = {0x3F, 0x06, 0x5B, 0x4F, 0x66, 0x6D,
                                    0x7D, 0x07, 0x7F, 0x6F, 0x77, 0x7C, 0x39, 0x5E,
                                    0x79, 0x71};
  static char displayflag = 0;
  int dh = display7Scodes[value >> 4];    // value to send to display hi
  int dl = display7Scodes[value & 0x0F];   // value to send to display low
  
  if(displayflag == 0){
    LATDbits.LATD6 = 0;                     // set display_low
    LATDbits.LATD5 = 1;
    LATB = (dl << 8) | (LATB & 0x00FF);    //send dl to display low 
  }
  else{
    LATDbits.LATD6 = 1;                     // set display_high
    LATDbits.LATD5 = 0;
    LATB = (dh << 8) | (LATB & 0x00FF);    //send dh to display high 
  }
  displayflag = !displayflag;
}
