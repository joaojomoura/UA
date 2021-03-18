#include <stdio.h>


int f3 (int n)
{
	int i, j, r = 0, num_adds = 0;
	for (i = 1; i <= n; i++)
		for (j = i; j <= n; j++){ 
			r += j;
			num_adds += 1;
		}
	printf("%d\n",num_adds );	
	return r;
}


int main (void) {
	int i;
	for (i = 1; i <= 10; i++)
		printf(" %d\n", f3(i));
	return 0;
}