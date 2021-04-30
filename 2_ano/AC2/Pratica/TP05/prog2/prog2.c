#include <detpic32.h>

void delay(int ms){
  for(;ms > 0; ms--){
    resetCoreTimer();
    while(readCoreTimer() < 20000);
  }
}

unsigned char toBcd(unsigned char value){
  return ((value / 10) << 4) + (value % 10);
}

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

int main (void){
  TRISB = TRISB & 0x80FF;                 // configurar RB14 a 8 como output (= 0)
  TRISD = TRISD & 0xFF9F;                 // configurar RD6 e RD5 como output
   
  TRISBbits.TRISB4 = 1;           // RBx digital output disconnected
  AD1PCFGbits.PCFG4= 0;           // RBx configured as analog input (AN4)
  AD1CON1bits.SSRC = 7;           // Conversion trigger selection bits: in this
                                  // mode an internal counter ends sampling and
                                  // starts conversion
  AD1CON1bits.CLRASAM = 1;        // Stop conversions when the 1st A/D converter
                                  // interrupt is generated. At the same time,
                                  // hardware clears the ASAM bit
  AD1CON3bits.SAMC = 16;          // Sample time is 16 TAD (TAD = 100 ns)
  AD1CON2bits.SMPI = 4-1;         // Interrupt is generated after XX samples
                                  // (replace XX by the desired number of
                                  // consecutive samples)
  AD1CHSbits.CH0SA = 4;           // replace x by the desired input
                                  // analog channel (0 to 15)
  AD1CON1bits.ON = 1;             // Enable A/D converter
                                  // This must the last command of the A/D
                                  // configuration sequence

  int cont = 0;
  unsigned int i;
  int v = 0;
  i = 0;
  while(1){
    if(i++ % 25 == 0) {
      AD1CON1bits.ASAM = 1;         // Start conversion
      while( IFS1bits.AD1IF == 0 ); // Wait while conversion not done
      int *p = (int *) (&ADC1BUF0);
      int sum = 0, media = 0;
      for(; p <= (int *) (&ADC1BUFF); p+=4){
        sum = sum + *p;
      }
    media = sum / 4;
    v = (media*33+511)/1023;
 }
    send2displays(toBcd(v));
    delay(10);
  }
  return 0;
}

