//Aula 05 Ex. 4

import java.util.Scanner;

public class Ex_4
{
	static Scanner sc = new Scanner (System.in);

	public static void main (String [] args)
	{
		//gets the number to calculate the fact
		int num_range = getIntRange ("Numero entre 1 e 10: ", 1, 10);
		
		//prints backwards
		for (int i = num_range; i >= 1; i--)
			fact (i);
	}

	//function getIntRange
	public static int getIntRange (String prompt, int range_min, int range_max){
		int n;
		
		//ask the user for a number
		do{
			System.out.print(prompt);
			n = sc.nextInt();
		}while(n < range_min || n > range_max);
		
		//return 
		return n;
	}

	//function to print the fact of the given number
	public static void fact (int n)
	{
		int fact = 1;
		for(int i = 1; i <= n; i++){
			fact = fact * i;
		}
		System.out.printf("%d! = %d\n", n, fact);
	}
}