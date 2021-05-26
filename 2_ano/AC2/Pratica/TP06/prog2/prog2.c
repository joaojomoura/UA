#include <detpic32.h>

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


volatile unsigned char voltage = 0;       // Global voltage variable
// delay
void delay(int ms){
  for(;ms > 0; ms--){
    resetCoreTimer();
    while(readCoreTimer() < 20000);
  }
}
// Interrupt Handler
void _int_(27) isr_adc(void){
  int *p = (int *) (&ADC1BUF0);
  int sum = 0, media = 0;
  for(; p <= (int *) (&ADC1BUF7); p+=4){
    sum = sum + *p;
  }
  media = sum / 8;
  voltage = (media*33+511)/1023;
  voltage = toBcd(voltage);
  IFS1bits.AD1IF = 0;               // Reset AD1IF flag
}


int main (void){
  
  // A/D module configuration
  TRISBbits.TRISB4 = 1;         // RB4 digital output disconnected
  AD1PCFGbits.PCFG4 = 0;        // RB4 configured as analog input (AN4)
  AD1CON1bits.SSRC = 7;         // internal counter ends sampling and starts conversion
  AD1CON1bits.CLRASAM = 1;      // Stop conversion when first interrupt is generated
  AD1CON3bits.SAMC = 16;        // Sample time is 16 TAD
  AD1CON2bits.SMPI = 8-1;       // Interrupt is generated after 1 sample 
  AD1CHSbits.CH0SA = 4;         // Channel AN4
  AD1CON1bits.ON = 1;           // Enable A/D converter

  // Digital I/O
  TRISB = TRISB & 0x80FF;       // RB14-8 as output
  TRISD = TRISD & 0xFF9F;       // RD6 and 5 as output
  // Configuration of interrupt system
  IPC6bits.AD1IP = 2;           // Configure priority of A/D interrupts
  IEC1bits.AD1IE = 1;           // Enable A/D interrupts
  IFS1bits.AD1IF = 0;           // Reset AD1IF flag

  // Global Interrupt Enable
  EnableInterrupts();

  
  unsigned int count = 0;
  while(1){
    if(count % 25 == 0){         //250  ms(4 samples per second)
      // Start A/D conversion
      AD1CON1bits.ASAM = 1; 
    }
    send2displays(voltage);
    count++;
    delay(10);
  }
  return 0;
}
