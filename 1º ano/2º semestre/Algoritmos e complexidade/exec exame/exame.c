#include <stdio.h>


int cc (int);
int cc1 (int);
int main () {
	printf("%d\n",cc(7));	
	printf("%d\n",cc1(7));
}

int cc (int n) {
	int a;
	int b = 1;
	int current = 2;
	for (int i = 2; i < n; i++) {
		a = b;
		b = current;
		current = (1 + b) / a;

	}
	return current;
}

int cc1 (int n) {
	if (n == 0)
		return 1;
	if (n == 1)
		return 2;
	return (1 + cc(n - 1)) / cc(n - 2);
}