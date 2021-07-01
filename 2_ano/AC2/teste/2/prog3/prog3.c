#include "../../utils/utils.h"

int main (void){
  configUart(115200,'N',1);
  while(1){
    putc('+');
    puts("String de teste\n");
    delay(1000);
  }
} 
