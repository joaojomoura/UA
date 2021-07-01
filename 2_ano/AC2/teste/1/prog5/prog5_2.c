#include "../../utils/utils.h"

volatile unsigned char v = 0;

int main (void){
  Adc(8);
  Interrupt(2);
  EnableInterrupts();

  unsigned int count = 0;

  while(1){
    if (count % 25 == 0)   // 250 ms (4 samples/second)
    {
      AD1CON1bits.ASAM = 1;
    }

    send2displays(toBcd(v));
    count++;
    delay(10);
  }
  return 0;
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
