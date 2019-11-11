#include <stdio.h>
#include <math.h>

int main(void)
{
	/* code */
	int i;

	for(i = 0; i <= 1000; i++){

		//obter os numeros do algarismo e fazer a suma soma elevado a potencia
		int number = i;
		int digit = 0;
		int sum_digit = 0;
		int count;
		
		while (number) {
			digit = number % 10;
			number /= 10;
			if(i < 10)
				sum_digit = i;

			if(i >= 100)
				sum_digit = sum_digit + pow(digit,3);

			else if (i >= 10)
				sum_digit = sum_digit + pow(digit,2);
			count ++;
		}
		
		//verificar se a soma das potencias dos numeros é igual a i
		if (i == sum_digit && i != 0){
			printf("%d\n", sum_digit);
			printf("numero de adiçoes: %d\n", count);

		}

	}
	return 0;
}