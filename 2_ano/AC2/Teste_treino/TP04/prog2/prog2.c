#include <detpic32.h>
#include "../delay.c"

int main(void){
  LATE = LATE & 0xFFF0;   // configuracao incial a 0
  TRISE = TRISE & 0xFFF0; // RE0-3 = 0, output

  int count = 0;
  while(1){
    delay(250);
    LATE = (LATE & 0xFFF0) | count ;
    count++;
  }
  return 0;
}

