#include <detpic32.h>
#include "delay.c"

void delay(int ms);

int main (void){
    LATCbits.LATC14 = 0;
    TRISCbits.TRISC14 = 0;
    while(1) {
        delay(500);
        LATCbits.LATC14 = !LATCbits.LATC14;
    }
    return 0;
}