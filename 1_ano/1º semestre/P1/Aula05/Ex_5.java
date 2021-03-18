//Aula 05 Ex. 5

import java.util.Scanner;

public class Ex_5
{
	static Scanner sc = new Scanner (System.in);

	public static void main (String [] args)
	{
		

		System.out.print("Altura: ");
		int row = sc.nextInt();
		System.out.print("Largura: ");
		int col = sc.nextInt();

		printer(row,col);

	}

	public static void printer (int row, int col)
	{
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
			{
				if((i != 0 && i != row-1) && (j != 0 && j != col-1))
					System.out.print(" ");
				else
					System.out.print("*");
			}
			System.out.println();
		}
	}
}