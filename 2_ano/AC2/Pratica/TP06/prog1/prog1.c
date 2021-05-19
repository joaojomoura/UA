#include <detpic32.h>

// delay
void delay(int ms){
  for(;ms > 0; ms--){
    resetCoreTimer();
    while(readCoreTimer() < 20000);
  }
}
// Interrupt Handler
void _int_(27) isr_adc(void){
  printInt(ADC1BUF0, 16 | 3 << 16); 
  printStr(" ");
  delay(500);
  AD1CON1bits.ASAM = 1;             // Start Conversion
  IFS1bits.AD1IF = 0;               // Reset AD1IF flag
}

int main (void){
  
  // A/D module configuration
  TRISBbits.TRISB4 = 1;         // RB4 digital output disconnected
  AD1PCFGbits.PCFG4 = 0;        // RB4 configured as analog input (AN4)
  AD1CON1bits.SSRC = 7;         // internal counter ends sampling and starts conversion
  AD1CON1bits.CLRASAM = 1;      // Stop conversion when first interrupt is generated
  AD1CON3bits.SAMC = 16;        // Sample time is 16 TAD
  AD1CON2bits.SMPI = 1-1;       // Interrupt is generated after 1 sample 
  AD1CHSbits.CH0SA = 4;         // Channel AN4
  AD1CON1bits.ON = 1;           // Enable A/D converter

  // Configuration of interrupt system
  IPC6bits.AD1IP = 2;           // Configure priority of A/D interrupts
  IEC1bits.AD1IE = 1;           // Enable A/D interrupts
  IFS1bits.AD1IF = 0;           // Reset AD1IF flag

  // Global Interrupt Enable
  EnableInterrupts();

  // Start A/D conversion
  AD1CON1bits.ASAM = 1;

  while(1){}
  return 0;
}
