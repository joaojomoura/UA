#include <detpic32.h>
#include "delay.c"

int main(void){
    unsigned char segment;
    LATDbits.LATD6 = 1;         //display high active
    LATDbits.LATD5 = 0;         // display low inactive
    LATB = LATB & 0x00FF;       // configura valor inicial antes da configuraçao bit 15 a 8 = 0
    TRISB = TRISB & 0x00FF;      // portas 8 a 14 = 0 (output)
    TRISD = TRISD & 0xFF9F;
    int i = 0;
    while(1){
        LATDbits.LATD6 = !LATDbits.LATD6;
        LATDbits.LATD5 = !LATDbits.LATD5;   // toggle display selection
        segment = 1;
        for(i = 0; i < 7; i++){
            LATB = (LATB & 0x00FF) | ((short)segment << 8);
            //LATB = LATB << 8;
            delay(10);
            segment = segment << 1;
        }
    }
    return 0;
}