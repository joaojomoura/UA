//Aula 9 Ex 1

import java.util.Scanner;

public class Ex9_1 {
	
	public static Scanner sc = new Scanner (System.in);

	public static void main (String [] args) {
		String sentence = read_sentence();
		print_sentence(sentence);

	}

	//read sentence from user
	public static String read_sentence () {

		String s = new String ();

		System.out.println("Analise de uma frase");
		
		//repeats if there's no sentence
		do{
			System.out.print("Frase de entrada -> ");
			s = sc.nextLine();
		}while(s.isEmpty());

		return s;
	}

	//counts the number of upper cases there are in a string
	public static int isUpper (String s) {

		int count = 0;

		for (int i = 0; i < s.length(); i++) 
			if (Character.isUpperCase(s.charAt(i)))
				count++;

		return count;
	}

	//counts the number of lower cases there are in a string
	public static int isLower (String s) {

		int count = 0;

		for (int i = 0; i < s.length(); i++) 
			if (Character.isLowerCase(s.charAt(i)))
				count++;

		return count;
	} 

	//counts the number of digits there are in a string
	public static int isDigit (String s) {

		int count = 0;

		for (int i = 0; i < s.length(); i++) 
			if (Character.isDigit(s.charAt(i)))
				count++;

		return count;
	}

	//count the number of vowels
	public static int count_vowels (String s) {

		int count_v = 0;

		for (int i = 0; i < s.length(); i++)
			if(isVowel(s.charAt(i)))
				count_v++;

		return count_v;
	}

	//count the number of cons
	public static int count_cons (String s) {
		int cons = isLower(s) + isUpper(s) - count_vowels(s);
		if (cons < 0)
			cons = - cons;
		return cons;
	}

	//function to see if it's a vowel
	public static boolean isVowel (char c) {
		
		c = Character.toLowerCase(c);
		//if is a vowel returns true
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
			return true;
		return false; // if not returns false
	}

	//function to print
	public static void print_sentence (String s) {

		System.out.printf("Número de caracteres minúsculos -> %d%nNúmero de caracteres maiúsculos -> %d%nNúmero de caracteres numéricos -> %d%n",
			isLower(s), isUpper(s), isDigit(s));
		System.out.printf("Número de vogais -> %d%nNúmero de consoantes -> %d%n", count_vowels(s), count_cons(s));
	}


}