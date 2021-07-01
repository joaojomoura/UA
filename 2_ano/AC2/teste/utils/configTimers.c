#include "getTimers.c"

void configTimerT1 (double fout){
  struct TimerConstants t = getTimersTypeA(fout);

  T1CONbits.TCKPS = t.TCKPS;
  PR1 = t.VALUE_PRx;
  TMR1 = 0;
  T1CONbits.TON = 1;

  printStr("Timer 1 Config");
  printStr("\nFout = "); printInt10(fout);
  printStr("\nK_PRESCALER = "); printInt10(t.K_PRESCALER);
  printStr("\nPr = "); printInt10(t.VALUE_PRx);
  printStr("\nTCKPS = "); printInt10(t.TCKPS);
  printStr("\n");
}

void configTimerT3 (double fout){
  struct TimerConstants t = getTimersTypeB(fout);

  T3CONbits.TCKPS = t.TCKPS;
  PR3 = t.VALUE_PRx;
  TMR3 = 0;
  T3CONbits.TON = 1;

  printStr("Timer 3 Config");
  printStr("\nFout = "); printInt10(fout);
  printStr("\nK_PRESCALER = "); printInt10(t.K_PRESCALER);
  printStr("\nPr = "); printInt10(t.VALUE_PRx);
  printStr("\nTCKPS = "); printInt10(t.TCKPS);
  printStr("\n");
}



void configTimerT2 (double fout){
  struct TimerConstants t = getTimersTypeB(fout);

  T2CONbits.TCKPS = t.TCKPS;
  PR2 = t.VALUE_PRx;
  TMR2 = 0;
  T2CONbits.TON = 1;

  printStr("Timer 2 Config");
  printStr("\nFout = "); printInt10(fout);
  printStr("\nK_PRESCALER = "); printInt10(t.K_PRESCALER);
  printStr("\nPr = "); printInt10(t.VALUE_PRx);
  printStr("\nTCKPS = "); printInt10(t.TCKPS);
  printStr("\n");
}

void configTimerInterruptT1 (int priority){
  IPC1bits.T1IP = priority;
  IEC0bits.T1IE = 1;
  IFS0bits.T1IF = 0;
}
void configTimerInterruptT2 (int priority){
  IPC2bits.T2IP = priority;
  IEC0bits.T2IE = 1;
  IFS0bits.T2IF = 0;
}
void configTimerInterruptT3 (int priority){
  IPC3bits.T3IP = priority;
  IEC0bits.T3IE = 1;
  IFS0bits.T3IF = 0;
}
