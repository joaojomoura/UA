#include "detpic32.h"
#include "send2displays.c"
#include "toBcd.c"

volatile int voltage = 0;   // Global variable       

int main(void)       
{          
  
    LATB = LATB & 0x00FF;       // configura valor inicial antes da configuraçao bit 15 a 8 = 0
    LATD = LATD & 0xFF9F;       // bit 5 e 6 = 0, FF 1001 F
    TRISB = TRISB & 0x00FF;     // configura portos RB15 a 8 como output

    TRISDbits.TRISD5 = 0;
    TRISDbits.TRISD6 = 0;

    // Configure all (digital I/O, analog input, A/D module, interrupts)
    TRISBbits.TRISB4 = 1;     // RBx digital output disconnected    
    AD1PCFGbits.PCFG4= 0;     // RBx configured as analog input (AN4)    
    AD1CON1bits.SSRC = 7;     // Conversion trigger selection bits: in this mode an internal counter ends sampling and starts conversion                              
                              
    AD1CON1bits.CLRASAM = 1;  // Stop conversions when the 1st A/D converter interrupt is generated. At the same time, hardware clears the ASAM bit                                
    AD1CON3bits.SAMC = 16;    // Sample time is 16 TAD (TAD = 100 ns)    
    AD1CON2bits.SMPI = 8-1;   // Interrupt is generated after XX samples (replace XX by the desired number of consecutive samples)                           
    AD1CHSbits.CH0SA = 4;     // replace x by the desired input analog channel (0 to 15) 

    AD1CON1bits.ON = 1;       // Enable A/D converter. This must the last command of the A/D configuration sequence


    IPC6bits.AD1IP = 2; // configure priority of A/D interrupts 
    IFS1bits.AD1IF = 0; // clear A/D interrupt flag
    IEC1bits.AD1IE = 1; // enable A/D interrupts


    // Configure Timer T3 (10 Hz with interrupts enabled) 

    T3CONbits.TCKPS = 5; // 1:32 prescaler (i.e. fout_presc = 20Mhz/32 KHz)    
    PR3 = 6249;         // Fout = 20MHz / (32 * (6249 + 1)) = 100 Hz  
    TMR3 = 0;            // Reset timer T3 count register    
    T3CONbits.TON = 1;   // Enable timer T3 (must be the last command of the timer configuration sequence)

    IPC3bits.T3IP = 2;   // Interrupt priority (must be in range [1..6])    
    IEC0bits.T3IE = 1;   // Enable timer T3 interrupts    
    IFS0bits.T3IF = 0;   // Reset timer T3 interrupt flag 

    // Configure Timer T1 (2 Hz with interrupts enabled) 

    T1CONbits.TCKPS = 3; // 1:256 prescaler (i.e. fout_presc = 78.125 KHz)    
    PR1 = 19531;         // Fout = 20MHz / (256 * (19530 + 1)) = 4 Hz  
    TMR1 = 0;            // Reset timer T1 count register    
    T1CONbits.TON = 1;   // Enable timer T1 (must be the last command of the timer configuration sequence)

    IPC1bits.T1IP = 2;   // Interrupt priority (must be in range [1..6])    
    IEC0bits.T1IE = 1;   // Enable timer T1 interrupts    
    IFS0bits.T1IF = 0;   // Reset timer T1 interrupt flag 

    
    // Reset AD1IF, T1IF and T3IF flags          
    
    EnableInterrupts();            // Global Interrupt Enable          
    while(1);       

} 

void _int_(4) isr_T1(void)       
{
    // Start A/D conversion     
    AD1CON1bits.ASAM = 1; 
     
    
    // Reset T1IF flag  
    IFS0bits.T1IF = 0;   // Reset timer T1 interrupt flag      
} 

void _int_(12) isr_T3(void)       
{   
    // Send "voltage" global variable to displays   
    send2displays(voltage);

    // Reset T3IF flag  
    IFS0bits.T3IF = 0;   // Reset timer T3 interrupt flag      
}

void _int_(27) isr_adc(void)
{
    // Calculate buffer average (8 samples)      
    // Calculate voltage amplitude 
    int sum = 0;

    int *p = (int *)(&ADC1BUF0); 
    for(; p <= (int *)(&ADC1BUF7); p+=4 ) 
    {    
        sum += *p;
    } 
    voltage = ((sum/8)*33+511)/1023;
    // Convert voltage amplitude to decimal. Assign it to "voltage"
    voltage = toBcd(voltage);
    IFS1bits.AD1IF = 0; // Reset AD1IF flag
}
