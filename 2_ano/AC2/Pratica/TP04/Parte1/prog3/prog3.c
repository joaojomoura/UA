#include <detpic32.h>
#include "delay.c"

int main (void){
    LATB = LATB & 0x00FF;       // configura valor inicial antes da configuraçao bit 15 a 8 = 0
    LATD = LATD & 0xFF9F;       // bit 5 e 6 = 0, FF 1001 F
    TRISB = TRISB & 0x00FF;     // configura portos RB15 a 8 como output
    TRISD = TRISD & 0xFF9F;     // configura portos RD5 e 6 como output

    LATDbits.LATD5 = 0;
    LATDbits.LATD6 = 1;

    while(1){
        char c = getChar();

        switch(c){
            case 'a' | 'A':
                LATB = LATB & 0x00FF;
                LATBbits.LATB8 = 1;
                break;

            case 'b' | 'B':
                LATB = LATB & 0x00FF;
                LATBbits.LATB9 = 1;
                break;
            
            case 'c' | 'C':
                LATB = LATB & 0x00FF;
                LATBbits.LATB10 = 1;
                break;

            case 'd' | 'D':
                LATB = LATB & 0x00FF;
                LATBbits.LATB11 = 1;
                break;

            case 'e' | 'E':
                LATB = LATB & 0x00FF;
                LATBbits.LATB12 = 1;
                break;

            case 'f' | 'F':
                LATB = LATB & 0x00FF;
                LATBbits.LATB13 = 1;
                break;
            
            case 'g' | 'G':
                LATB = LATB & 0x00FF;
                LATBbits.LATB14 = 1;
                break;
            
            case '-' :
                LATB = LATB & 0x00FF;
                LATBbits.LATB15 = 1;
                break;
            
            default:
                LATB = LATB & 0x00FF;
                break;
        }
    }
    return 0;
}