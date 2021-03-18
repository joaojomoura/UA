//Aula 3 Ex 3.10

import java.util.Scanner;

public class Ex3_10
{
	static Scanner sc = new Scanner (System.in);
	public static void main (String [] args)
	{
		int n = read_num();
		if (natural_number(n))
			System.out.printf("%d é um numero perfeito! \n", n); 
	}

	//ask the user for a number
	public static int read_num ()
	{
		int n;
		do
		{
			System.out.print("N: ");
			n = sc.nextInt();
		}while (n < 0);
		
		return n;
	}

	//checks if the number is a natural number
	public static boolean natural_number (int n)
	{
		int i = 1, sum  = 0;

		do
		{
			if(n % i == 0)
			{
				sum = sum +i;
			}
			i++;
		}while(i < n);

		if(sum == n)
			return true;

		return false;
	}
}