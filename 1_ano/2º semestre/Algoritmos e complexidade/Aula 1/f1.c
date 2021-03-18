#include <stdio.h>




int f1 (int n)
{
	int i, j, r = 0;
	for (i = 1; i <= n; i++)
		for (j = 1; j <= n; j++)
			r += 1;
	return r;
}

int main (void) {
	int i;
	for (i = 1; i <= 10; i++)
		printf("%d\n",f1(i));
	return 0;
}