#include <stdio.h>


int f2 (int n){
	int i, j, r = 0;
	for (i = 1; i <= n; i++)
		for (j = 1; j <= i; j++)
			r += 1;
	return r;
}


int main (void) {
	int i;
	for (i = 1; i <= 10; i++)
		printf("%d | %d\n", i, f2(i));
	return 0;
}