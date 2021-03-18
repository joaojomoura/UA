#include <stdio.h>

int main(void)
{
	/* code */
	int i;
	int f [] = {1,1,2,6,24,120,720,5040,40320,362880,36280800};

	for(i = 0; i <= 100000; i++){		//será executado 100001 vezes

		//obter os numeros do algarismo

		int number = i;
		int digit = 0;
		int sum_factorial = 0;
		//int count = 0;
		
		//soma do factorial de cada algarismo
		
		while (number) {				// será executado 100000 vezes x (soma de i = 0 até n(n sendo o numero de digitos))
			digit = number % 10;
			number /= 10;
			
			sum_factorial = sum_factorial + f[digit];
			//count ++;
		}




		//verificar se a soma dos factoriais é igual a i

		if (i == sum_factorial && i != 0){			// será 100000 x
			printf("%d\n", sum_factorial);
			//printf("numero de adiçoes: %d\n", count);

		}

	}
	return 0;
}