#include <detpic32.h>
#include "delay.c"

void delay(int ms); 

int main(void)
{
    LATE = LATE & 0xFFF0; //The initial value should be set before configuring the port as output

    TRISE = TRISE & 0xFFF0; //configure as output 

    int cnt = 0;
    while(1)
    {
        delay(125);
        LATE = (LATE & 0xFFF0) | cnt;
        cnt++;
    }
    return 0;
}
