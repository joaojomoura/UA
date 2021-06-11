#include "detpic32.h"
#include "../../parte1/prog4/configUART.c"

void putc(char byte2send){
  while(U2STAbits.UTXBF == 1);                    //wait while UTXBF==1
  U2TXREG = byte2send;
}

int main(void)
{
    configUart(115200, 'N', 1); // default "pterm" parameters
    // with RX interrupt enabled

    U2STAbits.URXISEL0 = 0;
    U2STAbits.URXISEL1 = 0;

    U2STAbits.UTXISEL0 = 0;
    U2STAbits.UTXISEL1 = 0;

    IEC1bits.U2RXIE = 1;
    IEC1bits.U2TXIE = 1;
    IEC1bits.U2EIE = 1;

    IPC8bits.U2IP = 2;
    IPC8bits.U2IS = 2;

    EnableInterrupts();
    while (1);
}


void _int_(32) isr_uart2(void)
{
    putc(U2RXREG);
    // Clear UART2 rx interrupt flag
    IFS1bits.U2RXIF = 0;

}
