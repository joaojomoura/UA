#include "../../utils/utils.h"

int main(void){
  LATE = LATE & 0xFFF0;       //initial value set

  TRISE = TRISE & 0xFFF0;     //RE0-3 set as output
  int count = 0;
  while(1){
    LATE = LATE & 0xFFF0 | count;  // 4 bits less significative isolated and adds count
    delay(250);
    count++;
  }
}
