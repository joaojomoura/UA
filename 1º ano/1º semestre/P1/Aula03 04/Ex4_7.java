//Aula 4 Ex 7

import java.util.Scanner;

public class Ex4_7
{
	static Scanner sc = new Scanner (System.in);
	public static void main (String [] args)
	{
		int n = read_num();
		reverse_order(n);
		System.out.println();
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

	// reverses the order of the given number
	public static void reverse_order (int n)
	{
		int res_div;

		/*
		*	gets the last digit of the number and then 
		*	extracts that same digit by dividing by 10 and 
		*	forcing to give an int
		*/
		do 
		{
			res_div = n % 10;
			n = (int) (n / 10);
			System.out.print(res_div); 
		}while(n > 0);
	}
}