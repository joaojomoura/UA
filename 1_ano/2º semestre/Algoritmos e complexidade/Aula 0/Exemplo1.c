#include <stdio.h>

int main(void)
{

	//teste de escrever strings na consola
	puts("Hello World");
	puts("João");
	puts("Moura");

	//Teste de pedir nome ao user
	char name [50];
	puts("What is your name?");
	fgets(name,100,stdin); //(array de char, numero de elementos, stdin)
	printf("Hello %s!\n", name);


	return 0; 
}