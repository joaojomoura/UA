//Aula 4 Ex 6

import java.util.Scanner;

public class Ex4_6
{
	static Scanner sc = new Scanner (System.in);
	public static void main (String [] args)
	{
		int n = read_num();
		int m = read_num();

		System.out.println(max_div(n,m));
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


	//gives the max common divisor
	public static int max_div (int n, int m)
	{
		int max, min, result;

		//check which is the largest and lowest number
		if (n < m)
		{	
			min = n;
			max = m;
		}
		else 
		{
			min = m;
			max = n;
		}

		//first we do the first division 
		result = max % min;	
		if (result == 0)
			return min;

		//then we repeat the division until the result is 0
		do
		{
			max = min;
			min = result;
			result = max % min;
			System.out.println(result);

		}while(result != 0);

		return min;


	}
}