#include <assert.h>
#include <stdio.h>
#include <math.h>
#include "elapsed_time.h"

typedef unsigned long long u64;

u64 NUM_ADDS_1;
u64 NUM_ADDS_2;

//version Recursiva


u64 F_v1 (int n) {
	
	
	assert(n >= 0);

	if(n < 2)
		return (u64)n;

	NUM_ADDS_1++;

	return F_v1(n - 1) + F_v1(n - 2);
}

u64 F_v2 (int n) {

	assert(n >= 0);
	if(n < 2)
		return (u64) n;

	u64 a = (u64) 0;
	u64 b = (u64) 1;
	u64 c;

	for (; n > 1; n--) {
		NUM_ADDS_2++;
		c = a+b;
		a = b;
		b = c;
	}
	return (u64)c;
}

u64 F_v3 (int n) {
	double k = (1.0 + sqrt(5.0))/2.0;
	return (u64) (pow(k,(double)n) - pow(1.0-k,(double)n))/sqrt(5.0);

}

u64 F_v4 (int n) {
	double k = (1.0 + sqrt(5.0))/2.0;
	return (u64) round ((pow(k,(double)n)/sqrt(5.0)));
}

int main (void) {
	int i;
	
	NUM_ADDS_2 = 0;
	double dt1, dt2, dt3;
	u64 fib;
	puts("Version 1");
	for (i = 0; i <40; i++) {
		//printf("%d | %lld | %lld\n", i, F_v1(i), NUM_ADDS_1);
		(void) elapsed_time();
		NUM_ADDS_1 = 0;
		fib = F_v1(i);
		dt1 = elapsed_time();
		printf("%3d | %20lld | %lld | %12.9f\n",i, fib, NUM_ADDS_1, dt1);
	}
	puts("Version 2");
	for (int j = 0; j <40; j++)
		printf("%d | %lld | %lld\n", j, F_v2(j), NUM_ADDS_2);

	puts("Version 3");
	fib = 0;
	for (int k = 0; k < 40; k++) {
		//printf("%d | %lld | %lld\n", i, F_v1(i), NUM_ADDS_1);
		(void) elapsed_time();
		NUM_ADDS_1 = 0;
		fib = F_v3(k);
		dt2 = elapsed_time();
		printf("%3d | %20lld | %lld | %12.9f\n",k, fib, NUM_ADDS_1, dt2);
	}

	puts("Version 4");
	fib = 0;
	for (int l = 0; l < 40; l++) {
		//printf("%d | %lld | %lld\n", i, F_v1(i), NUM_ADDS_1);
		(void) elapsed_time();
		NUM_ADDS_1 = 0;
		fib = F_v4(l);
		dt3 = elapsed_time();
		printf("%3d | %20lld | %lld | %12.9f\n",l, fib, NUM_ADDS_1, dt3);
	}
}