void send2displays(unsigned char value){
  static const char display7Scodes[] = {0x3F, 0x06, 0x5B, 0x4F, 0x66, 0x6D, 0x7D, 0x07, 0x7F, 0x6F, 0x77, 0x7C, 0x39, 0x5E, 0x79, 0x71};
  static char displayFlag = 0;        
  
  TRISB = TRISB & 0x80FF;
  TRISDbits.TRISD5 = 0;
  TRISDbits.TRISD6 = 0;     // set RB8 - 14 as output and RD5,RD6 also as output
  int digit_low = display7Scodes[value & 0x0F];
  int digit_high = display7Scodes[value >> 4];

  if(displayFlag == 0){
    LATDbits.LATD5 = 1;                                     //set display low
    LATDbits.LATD6 = 0;
    LATB = (LATB & 0x80FF) | digit_low << 8;               //send digit_low to display_low
  }
  else{
    LATDbits.LATD5 = 0;                                     //set display high
    LATDbits.LATD6 = 1;
    LATB = (LATB & 0x80FF) | digit_high << 8;               //send digit_high to display_high
  }

  displayFlag = !displayFlag;

}
