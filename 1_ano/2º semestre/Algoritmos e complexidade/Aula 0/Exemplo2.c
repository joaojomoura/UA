#include <stdio.h>

int main (void) {

	char name [50];

	puts("What is your name?");
	scanf("%s",name);
	printf("Hello %s\n",name);
}