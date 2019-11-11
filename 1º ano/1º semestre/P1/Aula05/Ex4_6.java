//Aula 4 Ex 4.6

import java.util.Scanner;

public class Ex4_6{

	public static void main (String [] args){
	
		//Scanner
		Scanner sc = new Scanner (System.in);
		
		//variables
		int num1 = 0;
		int num2 = 0;
		do
		{
			System.out.println("Valor numero 1: ");
			num1 = sc.nextInt();
			System.out.println("Valor numero 2: ");
			num2 = sc.nextInt();
		}while (num1 < 0 && num2 < 0);

		mdc( num1, num2);

	}

	//mdc
	public static void mdc (int n1, int n2)
	{
		int result = n1 % n2;

		while (n1 % n2 != 0)
		{
			n1 = n2;
			n2 = result;
			result = n1 % n2;
			
		}
		System.out.println(n2); 
	}
}
