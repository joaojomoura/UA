#include "detpic32.h"

void puts(char* str)
{
    while(*str != '\0')
    {
        putc(*str);
        str++;
    }
}
