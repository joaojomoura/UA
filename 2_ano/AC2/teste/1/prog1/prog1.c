#include "../utils/utils.h" 

int main(void){
  LATCbits.LATC14 = 0;      //initial value should be set before configuring the port as output

  TRISCbits.TRISC14 = 0;    //RC14 configured as output

  while(1){
    delay(500);
    LATCbits.LATC14 = !LATCbits.LATC14;
  }

  return 0;
}
