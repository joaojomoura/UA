//Aula 9 Ex 2

import java.util.Scanner;

public class Ex9_2 {
	
	public static Scanner sc = new Scanner (System.in);

	public static void main (String [] args) {

		String sentence = new String();
		//loops until there's no sentence provided by the user
		do{
			sentence = read_sentence();
			print_acro(sentence);
		}while(!sentence.isEmpty());

	}

	//read sentence from user
	public static String read_sentence () {

		String s = new String ();

		System.out.println("Acronimo de uma frase");
		System.out.print("Frase de entrada -> ");
		s = sc.nextLine();

		return s;
	}

	//Funtion to write a string with only upper cases
	public static String acro (String s) {

		char c = ' ';
		String acro = new String();

		//for each letter verifies if is Upper case.
		for (int i = 0; i < s.length(); i++) {
			if (Character.isUpperCase(s.charAt(i))){
				c = s.charAt(i);
				acro = acro + c;	//if it is Upper case adds the letter to a new String
			}
			
		}

		return acro;
	}

	public static void print_acro (String s) {
		System.out.printf("acronimo(\"%s\") devolve \"%s\"%n",s,acro(s));
	}

}