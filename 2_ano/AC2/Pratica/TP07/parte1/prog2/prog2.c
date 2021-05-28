#include <detpic32.h>

void _int_(12) isr_T3(void){
  putChar('.');
  IFS0bits.T3IF = 0;
}

int main(void){
  //configure Timer T3
  T3CONbits.TCKPS = 7;          //Kprescaler = 256, FoutPrescaler = 78125
  PR3 = 39062;
  TMR3 = 0;                     // Reset Timer T3 counter
  T3CONbits.TON = 1;            // enable Timer T3

  //configure Timer T3 interrupts
  IPC3bits.T3IP = 2;            // set priority
  IEC0bits.T3IE = 1;            // Enable interrupts
  IFS0bits.T3IF = 0;            // reset interrupt flag
  EnableInterrupts();

  while(1);
  return 0;
}
