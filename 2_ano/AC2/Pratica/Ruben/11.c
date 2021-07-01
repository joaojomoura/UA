#include "stuff.c"
#include "putc.c"
#include "puts.c"
#include "comDrv_config.c"

static volatile circularBuffer txb; // Transmission buffer
static volatile circularBuffer rxb; // Reception buffer 

void comDrv_flushRx(void);
void comDrv_flushTx(void);
void comDrv_putc(char ch);
void comDrv_puts(char *s);
char comDrv_getc(char *pchar);

int main(void)
{
    comDrv_config(115200,'N',1); // default "pterm" parameters
    // with TX and RX interrupts disabled

    U2STAbits.URXISEL0 = 0;
    U2STAbits.URXISEL1 = 0;

    U2STAbits.UTXISEL0 = 0;
    U2STAbits.UTXISEL1 = 0;

    IEC1bits.U2RXIE = 1;
    IEC1bits.U2TXIE = 1;
    IEC1bits.U2EIE = 1;

    IPC8bits.U2IP = 1;
    IPC8bits.U2IS = 1;

    comDrv_flushRx();
    comDrv_flushTx();
    EnableInterrupts();

    comDrv_puts("PIC32 UART Device-driver\n");
    while(1)
    {
        // Read character from reception buffer
        char c; 
        if(comDrv_getc(&c))
        {
            // Send character to the transmission buffer
            comDrv_putc(c);
        }
    } 
}

void comDrv_flushRx(void)
{
    // Initialize variables of the reception buffer
    rxb.count = 0;
    rxb.head = 0;
    rxb.tail = 0;
    
}
void comDrv_flushTx(void)
{
    // Initialize variables of the transmission buffer
    txb.count = 0;
    txb.head = 0;
    txb.tail = 0;
}

void comDrv_putc(char ch)
{
    while(txb.count == BUF_SIZE){} // Wait while buffer is full
    txb.data[txb.tail] = ch; // Copy character to the transmission
    // buffer at position "tail"
    // txb.tail = (txb.tail + 1) & INDEX_MASK; // Increment "tail" index
    txb.tail = (txb.tail + 1) & INDEX_MASK;
    // (mod. BUF_SIZE)
    DisableUart2TxInterrupt(); // Begin of critical section
    // Increment "count" variable
    txb.count += 1;
    EnableUart2TxInterrupt(); // End of critical section
} 

void comDrv_puts(char *s)
{
    while(*s != '\0')
    {
        comDrv_putc(*s);
        s++;
    }
    comDrv_putc('\0');
}

char comDrv_getc(char *pchar)
{
    // Test "count" variable (reception buffer) and return FALSE if it is zero
    if(rxb.count == 0) return 0;

    DisableUart2RxInterrupt(); // Begin of critical section
    // Copy character pointed by "head" to *pchar
    *pchar = rxb.data[rxb.head];
    // Decrement "count" variable
    rxb.count -= 1;
    // Increment "head" variable (mod BUF_SIZE)
    rxb.head = (rxb.head + 1) & INDEX_MASK;
    EnableUart2RxInterrupt(); // End of critical section
    return 1;
} 

void _int_(32) isr_uart2(void)
{
    if(IFS1bits.U2TXIF)
    {
        while(txb.count > 0 && !U2STAbits.UTXBF)
        {
            U2TXREG = txb.data[txb.head];
            txb.head = (txb.head + 1) & INDEX_MASK;
            txb.count -= 1;
        }

        if(txb.count == 0)
        {
           DisableUart2TxInterrupt();
        }

        IFS1bits.U2TXIF = 0;
    }

    if(IFS1bits.U2RXIF)
    {
        while(U2STAbits.URXDA) //not sure if there's something else i should check since this may overrun the buffer. not an issue here since we're constabtly reading with getc
        {
            rxb.data[rxb.tail] = U2RXREG;

            rxb.tail = (rxb.tail + 1) & INDEX_MASK;
            if(rxb.count < BUF_SIZE)
            {
                rxb.count += 1;
            }
            else
            {
                rxb.head = (rxb.head + 1) & INDEX_MASK;
            }
        }
        
        IFS1bits.U2RXIF = 0;
    }

}


