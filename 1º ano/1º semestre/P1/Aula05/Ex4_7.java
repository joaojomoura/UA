//Aula 4 Ex 4.7

import java.util.Scanner;

public class Ex4_7{

	public static void main (String [] args){
	
		int n = read_number();
		print(n);

		
	}

	public static int read_number ()
	{
		//Scanner
		Scanner sc = new Scanner (System.in);
		int n = 0;

		//Read number from user
		do 
		{
			System.out.print("Numero inteiro positivo: ");
			n = sc.nextInt();
		}while (n <= 0);

		return n;
	}

	public static void print (int n)
	{
		int pos = 1;
		int number = (n % 10) / pos;
		System.out.print(number);

		while(number != 0)
		{
			pos = pos * 10;
			number = (n % (pos * 10)) / pos;
			if(number != 0)
			System.out.print( number );
		}
		
	} 
}