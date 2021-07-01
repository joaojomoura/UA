#include "../../utils/utils.h"

volatile unsigned char v = 0;

int main (void){
  TRISBbits.TRISB0 = 1;
  TRISBbits.TRISB1 = 1;
  Adc(8);
  Interrupt(2);
  configTimerT1(4);
  configTimerInterruptT1(2);
  configTimerT3(100);
  configTimerInterruptT3(2);
  IFS0bits.T1IF = 0;
  IFS0bits.T3IF = 0;
  IFS1bits.AD1IF = 0;
  EnableInterrupts();

  unsigned int count = 0;
  int ds = 0;
  while(1){
    ds = PORTB & 0x03;
    if(ds == 1)
      IEC0bits.T1IE = 0;
    else
      IEC0bits.T1IE = 1;
  }
  return 0;
}

void _int_(4) isr_T1(void){
  AD1CON1bits.ASAM = 1;
  IFS0bits.T1IF = 0;
}

void _int_(27) isr_adc(void){
   int *p = (int *) (&ADC1BUF0);
   int sum = 0, media = 0;
   for (; p <= (int *) (&ADC1BUF7); p+=4){
      sum = sum + *p;
   }
   media = sum / 8;
   v = voltage(media);
   IFS1bits.AD1IF = 0;
}

void _int_(12) isr_T3(void){
  send2displays(toBcd(v));
  IFS0bits.T3IF = 0;
}
