#include <detpic32.h>
#include "delay.c"

int main(void){
    static const char display7Scodes [] = {0x3F, 0x06, 0x5B, 0x4F, 0x66, 0x6D,
                                    0x7D, 0x07, 0x7F, 0x6F, 0x77, 0x7C, 0x39, 0x5E,
                                    0x79, 0x71};
    TRISD = TRISD & 0xFF9F;
    TRISB = (TRISB & 0xFFF0) | 0x000F;       // RB3 a 4 = 1 (input)
    TRISB = TRISB & 0x80FF;                 // RB14 a 8 = 0 (output)
    
    LATB = LATB & 0x00FF;                   // first config

    LATDbits.LATD6 = 0;
    LATDbits.LATD5 = 1;
    unsigned char put;
    char c;

    while(1){
        put = PORTB & 0x000F;
        c = display7Scodes[put];
        LATB = (LATB & 0x0000) | ((int) c << 8);
    }
    return 0;
}