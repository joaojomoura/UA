#include "detpic32.h"

int main(void)
{
    // Configure Timer T3 (10 Hz with interrupts enabled) 

    T3CONbits.TCKPS = 5; // 1:32 prescaler (i.e. fout_presc = 20Mhz/32 KHz)    
    PR3 = 62499;         // Fout = 20MHz / (32 * (62499 + 1)) = 10 Hz  
    TMR3 = 0;            // Reset timer T3 count register    
    T3CONbits.TON = 1;   // Enable timer T3 (must be the last command of the timer configuration sequence)

    IPC3bits.T3IP = 2;   // Interrupt priority (must be in range [1..6])    
    IEC0bits.T3IE = 1;   // Enable timer T3 interrupts    
    IFS0bits.T3IF = 0;   // Reset timer T3 interrupt flag 

    // Configure Timer T1 (2 Hz with interrupts enabled) 

    T1CONbits.TCKPS = 3; // 1:256 prescaler (i.e. fout_presc = 78.125 KHz)    
    PR1 = 39062;         // Fout = 20MHz / (256 * (39062 + 1)) = 2 Hz  
    TMR1 = 0;            // Reset timer T1 count register    
    T1CONbits.TON = 1;   // Enable timer T1 (must be the last command of the timer configuration sequence)

    IPC1bits.T1IP = 2;   // Interrupt priority (must be in range [1..6])    
    IEC0bits.T1IE = 1;   // Enable timer T1 interrupts    
    IFS0bits.T1IF = 0;   // Reset timer T1 interrupt flag 

    EnableInterrupts();

    while(1)       
    { }
}

void _int_(12) isr_T3(void)      // Replace VECTOR by the timer T3 vector number    
{       
    putChar('3');       
    
    IFS0bits.T3IF = 0;   // Reset timer T3 interrupt flag 
} 

void _int_(4) isr_T1(void)      // Replace VECTOR by the timer T3 vector number    
{       
    putChar('1');       
    
    IFS0bits.T1IF = 0;   // Reset timer T1 interrupt flag 
} 
