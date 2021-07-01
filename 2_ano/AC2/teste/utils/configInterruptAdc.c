void Interrupt(int priority){
  IPC6bits.AD1IP = priority;   //priority A/D interrupts
  IFS1bits.AD1IF = 0;         // clear A/D interrupt flag
  IEC1bits.AD1IE = 1;         // Enable A/D interrupts
}
