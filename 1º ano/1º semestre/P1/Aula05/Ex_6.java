//Aula 05 Ex. 6

import java.util.Scanner;

public class Ex_6
{
	static Scanner sc = new Scanner (System.in);

	public static void main (String [] args)
	{
		//asks the user for a number
		int number = getIntRange("Numero entre 0 e 100: ", 0, 100);
		printTabuada(number);

	}

	//function getIntRange
	public static int getIntRange (String prompt, int range_min, int range_max){
		int n;
		
		//ask the user for a number
		do{
			System.out.print(prompt);
			n = sc.nextInt();
		}while(n <= range_min || n >= range_max);
		
		//return 
		return n;
	}

	//function to print
	public static void printTabuada (int n)
	{
		System.out.println("-------------------");
		System.out.println("| Tabuada dos ##  |");
		System.out.println("-------------------");
		for (int i = 1; i <= 10; i++)
			System.out.printf("| %2d x %2d  |  %3d |\n", n, i, n*i);
		System.out.println("-------------------");
	}
}