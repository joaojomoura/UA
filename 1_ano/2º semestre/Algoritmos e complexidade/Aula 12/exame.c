#include <stdio.h>

int main () {
	printf("%d\n",exame(5));	

}

int exame (int n) {
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