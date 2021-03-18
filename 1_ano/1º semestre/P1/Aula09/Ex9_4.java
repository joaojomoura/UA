//Aula 9 Ex 4

import java.util.Scanner;

public class Ex9_4 {
	
	public static Scanner sc = new Scanner (System.in);

	public static void main (String [] args) {
		int c = (int) 'a';
		System.out.println(c);

		char tmp = sc.nextLine().charAt(0);
		int tmp2 = (int) tmp;
		if(tmp2 >= 65 && tmp2 <= 90)
			System.out.printf("char %c é maiusculo", tmp);

	}


	//verify if is a pattern
	public static boolean matchPattern (String s, String ptr) { 
		

	}

}