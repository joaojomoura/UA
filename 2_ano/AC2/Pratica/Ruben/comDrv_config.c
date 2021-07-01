#include "detpic32.h"

void comDrv_config(unsigned int baud, char parity, unsigned int stopbits)
{
    // Configure BaudRate Generator
    // Configure number of data bits (8), parity and number of stop bits
    // Enable the trasmitter and receiver modules
    // Enable UART2

    if(baud < 600 || baud > 115200)
    {
        baud = 115200;
    }

    U2BRG = ((PBCLK + 8 * baud) / (16 * baud)) - 1 ;

    U2MODEbits.BRGH = 0;
    // 2 – Configure number of data bits, parity and number of stop bits
    if(parity == 'E')
    {
        U2MODEbits.PDSEL1 = 0;
        U2MODEbits.PDSEL0 = 1;
    }
    if(parity == 'O')
    {
        U2MODEbits.PDSEL1 = 1;
        U2MODEbits.PDSEL0 = 0;
    }
    else
    {
        U2MODEbits.PDSEL1 = 0;
        U2MODEbits.PDSEL0 = 0;
    }
    
    if(stopbits == 2)
    {
        U2MODEbits.STSEL = 1; 
    }
    else
    {
        U2MODEbits.STSEL = 0; 
    }

    // (see U2MODE register)
    // 3 – Enable the trasmitter and receiver modules (see register U2STA)
    U2STAbits.UTXEN = 1;
    U2STAbits.URXEN = 1;
    // 4 – Enable UART2 (see register U2MODE)
    U2MODEbits.ON = 1;
}
