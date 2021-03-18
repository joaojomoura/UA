#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

/* alusão das funções que implementam os algoritmos pretendidos */
/* allusion to the functions that implement the required algorithms */
long unsigned int PerrinRec (unsigned int);
long unsigned int PerrinDin (unsigned int);
int PerrinDin2 (int);

/* variável global para contar as adições executadas pelo algoritmo */
/* global variable for counting the sums executed by the algorithm */
int Sum;

int main (void)
{
	int Line, N, Test;
	long unsigned int Result;

	/* leitura do valor limite da tabela */
	/* reading the limit value for the table */
	do
	{
		printf ("N? "); Test = scanf ("%d", &N);
		scanf ("%*[^\n]"); scanf ("%*c");
	} while (Test == 0);

    /* impressão da tabela de execução do algoritmo */
    /* impression of the table values for the algorithm's execution */
	for (Line = 0; Line <= N; Line++)
	{
        /* inicialização da variável global contadora das adições */
        /* initialization of the global variable for counting the sums */
		Sum = 0;

		/* invocação do algoritmo pretendido */
		/* invocation of the pretended algorithm */
		Result = PerrinRec (Line);

		/* apresentação do resultado e do número de adições executadas pelo algoritmo */
		fprintf (stdout, "P(%2d) = %4lu e fez %2d somas\n\n", Line, Result, Sum);

		/* presenting the result and the number of sums executed by the algorithm */
		Sum = 0;
		Result = PerrinDin (Line);
		fprintf (stdout, "P(%2d) = %4lu and made %2d sums\n\n", Line, Result, Sum);

		Sum = 0;
		Result = PerrinDin2 (Line);
		fprintf (stdout, "P2(%2d) = %4lu and made %2d sums\n\n", Line, Result, Sum);
	}


	scanf ("%*c");
	exit (EXIT_SUCCESS);
}

/* implementação dos algoritmos pretendidos */
/* acrescentar a contagem das invocações recursivas executadas pelos algoritmos usando a variável global */

/* implementation of the pretended algorithms */
/* do not forget to count the recursive calls using the global variable */

long unsigned int PerrinRec (unsigned int n)
{
	if(n == 0)
		return 3;
	else if (n == 1)
		return 0;
	else if (n == 2)
		return 2;
	else if (n > 2){
		Sum++;
		return PerrinRec(n - 2) + PerrinRec(n - 3);
	}
	return 0;
}

long unsigned int PerrinDin (unsigned int n)
{
	long int a = 3;
	long int b = 0;
	long int c = 2;
	long unsigned int m;
	if (n == 0) 
        return a; 
    if (n == 1) 
        return b; 
    if (n == 2) 
        return c;
    while (n > 2) {
    	Sum++;
    	m = a + b;
    	a = b;
    	b = c;
    	c = m;
    	n--;
    }

	return m;
}

int PerrinDin2 (int n) {

	int *ptr;
	ptr = (int*) malloc((n+1) * sizeof(int));
	ptr [0] = 3;
	ptr [1] = 0;
	ptr [2] = 2;
	int a = ptr [0];
	int b = ptr [1];
	int c = ptr [2];
	for (int i = 3; i <= n; i++) {
		
		Sum++;
		ptr[i] = a+b ;
		a = b;
		b = c;
		c = ptr [i];
	}
	free(ptr);
	return c; 
	

}


