#include <detpic32.h>
#include "getTimerConstants.c"

void configTimerT1 (int fout){
  struct TimerConstants t = getTimerConstantsTypeA(fout);

  T1CONbits.TCKPS = t.TCKPS;
  PR1 = t.VALUE_PRx;
  TMR1 = 0;
  T1CONbits.TON = 1;

  printStr("Timer 1 Config");
  printStr("\nFout = "); printInt10(fout);
  printStr("\nK_PRESCALER = "); printInt10(t.K_PRESCALER);
  printStr("\nPr = "); printInt10(t.VALUE_PRx);
  printStr("\nTCKPS = "); printInt10(t.TCKPS);
}

void configTimerT3 (int fout){
  struct TimerConstants t = getTimerConstantsTypeB(fout);

  T3CONbits.TCKPS = t.TCKPS;
  PR3 = t.VALUE_PRx;
  TMR3 = 0;
  T3CONbits.TON = 1;

  printStr("Timer 3 Config");
  printStr("\nFout = "); printInt10(fout);
  printStr("\nK_PRESCALER = "); printInt10(t.K_PRESCALER);
  printStr("\nPr = "); printInt10(t.VALUE_PRx);
  printStr("\nTCKPS = "); printInt10(t.TCKPS);
}



void configTimerT2 (int fout){
  struct TimerConstants t = getTimerConstantsTypeB(fout);

  T2CONbits.TCKPS = t.TCKPS;
  PR2 = t.VALUE_PRx;
  TMR2 = 0;
  T2CONbits.TON = 1;

  printStr("Timer 2 Config");
  printStr("\nFout = "); printInt10(fout);
  printStr("\nK_PRESCALER = "); printInt10(t.K_PRESCALER);
  printStr("\nPr = "); printInt10(t.VALUE_PRx);
  printStr("\nTCKPS = "); printInt10(t.TCKPS);
}
void configInterrupts_TimerT1(){
    IPC1bits.T1IP = 2; 
    IEC0bits.T1IE = 1;
    IFS0bits.T1IF = 0; 
}

void configInterrupts_TimerT2() {
    IPC2bits.T2IP = 2;
    IEC0bits.T2IE = 1;
    IFS0bits.T2IF = 0;
}

void configInterrupts_TimerT3() {
    IPC3bits.T3IP = 2; // Interrupt priority (must be in range [1..6])
    IEC0bits.T3IE = 1; // Enable timer T3 interrupts
    IFS0bits.T3IF = 0; // Reset timer T3 interrupt flag
}
