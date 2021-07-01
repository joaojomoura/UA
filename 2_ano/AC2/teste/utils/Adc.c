//Analogic Digital Converter
//
//

void Adc (int n){
  TRISBbits.TRISB4 = 1;              // RB4 digital output disconnected
  AD1PCFGbits.PCFG4 = 0;            // RB4 configured as analog input (AN4)
  AD1CON1bits.SSRC = 7;             // Conversion trigger selection bits
  AD1CON1bits.CLRASAM = 1;          // Stop conversion when 1st ADC interrupt is generated
  AD1CON3bits.SAMC = 16;            // Sample time is 16 TAD
  AD1CON2bits.SMPI = n - 1;         // Interrupt is generated after n samples
  AD1CHSbits.CH0SA = 4;             // Analog channel
  AD1CON1bits.ON = 1;               // Enable ADC
}
