#include <detpic32.h>

int main (int ms){
  for(; ms > 0; ms--){
    resetCoreTimer();
    while(readCoreTimer() < 20000);
  }
}
