



//Aula 3 Ex 3.9

import java.util.Scanner;
import java.lang.Math;

public class Ex3_9
{
	static Scanner sc = new Scanner (System.in);
	public static void main (String [] args)
	{
		
		int n = read_num();
		print(n);
	}
	
	//ask the user
	public static int read_num ()
	{
		int n;
		do
		{
			System.out.print("N: ");
			n = sc.nextInt();
		}while (n < 0 || n > 1000);
		return n;
	}
	
	//check if its even
	public static boolean even (int n)
	{
		if (n % 2 == 0)
			return true;
		return false;
	}
	
	// prints the even numbers and its sum
	public static void print (int n)
	{
		int sum = 0, i = 1, even = 0;
		/*
		 * Goes from 1 to i and if it finds a even number, print, add to
		 * sum and increments the variable even, until finds n even 
		 * numbers  
		*/
		do
		{
			if(even(i))
			{
				System.out.printf("%d ", i);
				sum = sum + i;
				even++;
			}
			i++;
		}while(even != n);
		
		
		System.out.printf("\nSoma = %d\n", sum);
	}
		
	
}
		
