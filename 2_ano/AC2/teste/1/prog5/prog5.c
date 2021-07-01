#include "../../utils/utils.h"

int main (void){
  Adc(1);
  Interrupt(2);
  EnableInterrupts();
  AD1CON1bits.ASAM = 1;

  while(1){}
  return 0;
}

void _int_(27) isr_adc(void){
   printInt(ADC1BUF0, 16| 3 << 16);
   printStr("\n");
   AD1CON1bits.ASAM = 1;
   IFS1bits.AD1IF = 0;


}
