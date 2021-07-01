#include "../../utils/utils.h"

int main(void){
  unsigned int i = 0;
  int count = 0;
  while(1){
    i++;
    send2displays(toBcd(count));
    delay(10);
    if(i % 20 == 0)
      count++;
  }
  return 0;
}
