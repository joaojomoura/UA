//Aula 9 Ex 3

import java.util.Scanner;

public class Ex9_3 {
	
	public static Scanner sc = new Scanner (System.in);

	public static void main (String [] args) {

		String sentence = new String ();
		sentence = read_sentence();
		prints(sentence);

	}

	//read sentence from user
	public static String read_sentence () {

		String s = new String ();

		System.out.print("Frase de entrada -> ");
		s = sc.nextLine();

		return s;
	}

	// count the number of words
	public static int count_words (String s) {

		String [] t = s.split(" ");	//split the sentence in an array of wrods
		int count = t.length;		//the length of the array is the number of words
		return count;
	}

	//print
	public static void prints (String s) {
		System.out.printf("countWords(\"%s\") devolve %d%n",s,count_words(s));
	}
}