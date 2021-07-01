#include "../../utils/utils.h"

int main (void){
  Adc(4);
  unsigned int i = 0;
  int v = 0;
  while(1){
    if(i++ % 25 == 0){
      AD1CON1bits.ASAM = 1;
      while(IFS1bits.AD1IF == 0);
      int sum = 0, media = 0;
      int *p = (int *) (&ADC1BUF0);
      for(; p <= (int *) (&ADC1BUFF); p+=4){
        sum = sum + *p;
      }
      media = sum / 4;
      v = voltage(media);
    }
    send2displays(toBcd(v));
    delay(10);
    IFS1bits.AD1IF == 0;
  }
}
