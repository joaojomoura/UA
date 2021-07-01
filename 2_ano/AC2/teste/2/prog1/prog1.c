#include "../../utils/utils.h"

int main (void){
  configTimerT1(2);
  configTimerInterruptT1(2);
  configTimerT3(20);
  configTimerInterruptT3(2);
  IFS0bits.T3IF = 0;
  IFS0bits.T1IF = 0;
  EnableInterrupts();
  while(1){
   // while(IFS0bits.T3IF == 0);
   // IFS0bits.T3IF = 0;
   // putChar('.');
  }
  return 0;
}

void _int_(12) isr_T3(void){
  putChar('3');
  IFS0bits.T3IF = 0;
}



void _int_(4) isr_T1(void){
  putChar('1');
  IFS0bits.T1IF = 0;
}
