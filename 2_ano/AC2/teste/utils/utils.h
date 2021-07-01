//Alls configurations of AC2


#include <detpic32.h>
#include "delay.c"
#include "toBcd.c"
#include "send2displays.c"
#include "Adc.c"
#include "voltage.c"
#include "configInterruptAdc.c"
#include "configTimers.c"
#include "putc.c"
#include "puts.c"
#include "ConfigUart.c"
#include "bufferUart.h"
#include "devicedriver.c"
//delay
void delay(int ms);

//to decimal
unsigned char toBcd (unsigned char value);

//send to displays
void send2displays(unsigned char value);

//Config ADC with analog port 4
void Adc(int n);


// voltage
int voltage(int media);

//Configure Interrupt system
void Interrupt (int priority);

//Configure Timers
void configTimerT1(double fout); 
void configTimerT2(double fout); 
void configTimerT3(double fout); 
void configTimerInterruptT1(int priority);
void configTimerInterruptT2(int priority);
void configTimerInterruptT3(int priority);


//config UART
void configUart (unsigned int baud, char parity, unsigned int stopbits);

//putc
void putc(char byte2send);

//puts
void puts(char *str);


//device diver
void comDrv_flushRx(void);
void comDrv_flushTx(void);
void comDrv_putc(char ch);
void comDrv_puts(char *s);
void _int_(32) isr_uart2(void);
char comDrv_getc(char *pchar);
