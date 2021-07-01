#include "detpic32.h"

void putc(char byte2send)
{
    // wait while UTXBF == 1
    while(U2STAbits.UTXBF == 1)
    // Copy byte2send to the UxTXREG register
    U2TXREG = byte2send;
} 
