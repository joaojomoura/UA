#include <math.h>

struct TimerConstants {
    int K_PRESCALER;
    int TCKPS;
    int VALUE_PRx;
};

struct TimerConstants getTimersTypeB (double fout) {
  int c = 65535;
  int div_cont [] = {1,2,4,8,16,32,64,256};
  int size = sizeof(div_cont)/sizeof(div_cont[0]);
  int k = ceil(PBCLK/((c + 1) * fout));
  int i = 0;
  
  for (i = 0; i < size; i++){
    if(k < div_cont[i]){
      k = div_cont[i];
      break;
    }
  }
  int tckps = i;
  int pr = PBCLK / k;
  pr = ceil(pr/fout)-1;
  
  struct TimerConstants t;
  t.VALUE_PRx = pr;
  t.K_PRESCALER = k;
  t.TCKPS = tckps;

  return t;
}

struct TimerConstants getTimersTypeA (double fout) {
  int c = 65535;
  int div_cont [] = {1,86,64,256};
  int size = sizeof(div_cont)/sizeof(div_cont[0]);
  int k = ceil(PBCLK/((c + 1) * fout));
  int i = 0;
  
  for (i = 0; i < size; i++){
    if(k < div_cont[i]){
      k = div_cont[i];
      break;
    }
  }
  int tckps = i;
  int pr = PBCLK / k;
  pr = ceil(pr/fout)-1;
  
  struct TimerConstants t;
  t.VALUE_PRx = pr;
  t.K_PRESCALER = k;
  t.TCKPS = tckps;

  return t;

}
