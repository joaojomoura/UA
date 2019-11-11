//Aula 3 Ex 3.11

import java.util.Scanner;

public class Ex3_11
{
	static Scanner sc = new Scanner (System.in);
	public static void main (String [] args)
	{
		char c = ' ';

		for (int i = 8; i > 0; i--)
		{
			for (int j = 0; j < 8; j++)
			{
				c = (char) ('a' + j);
				System.out.printf("%c%d ", c, i);

			}
			System.out.println();
		}
	}
}