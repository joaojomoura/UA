#include <detpic32.h>
#include "delay.c"

int main (void){
    LATE = LATE & 0xFFF0;       //configurar valor inicial antes da configuraçao
    TRISE = TRISE & 0xFFF0;      // configurar portos RE0 a 3 como OUTPUTS (0 = output 1 = input)

    int cnt = 0;
    while(1){
        delay(250);             // frequencia de 4Hz
        LATE = (LATE & 0xFFF0) | cnt;       // isola os 4 bits menos significativos e junta o valor de cnt
        cnt++;
    }
    return 0;
}