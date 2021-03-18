/**
 * 
 */
package aula1.ex1;

import java.util.Scanner;
import static  java.lang.System.*;




/**
 * @author slowbro
 *
 */
public class Problema1 {

	/**
	 * @param args
	 */
	public static Scanner sc = new Scanner (System.in);
	public static void main(String[] args) {
	String frase = read();
	out.println(count_numbers(frase));
	out.println(min(frase));
	out.println(max(frase));
	out.println(trade(frase));
	for(String s : total_words(frase))
		out.println(s);
	

	}
	
	public static String read() {
		System.out.print("Frase: ");
		String frase = sc.nextLine();
		return frase;
	}
	
	public static int count_numbers(String sentence) {
		return (int) sentence.chars()
				.filter(c -> Character.isDigit(c))
				.count();
	}
	public static boolean min(String sentence) {
		for(int i = 0; i < sentence.length(); i++) {
			if(Character.isUpperCase(sentence.charAt(i)) 
					|| Character.isDigit(sentence.charAt(i)))
				return false;
		}
		return true;
	}
	
	public static boolean max(String sentence) {
		for(int i = 0; i < sentence.length(); i++) {
			if(Character.isLowerCase(sentence.charAt(i)) 
					|| Character.isDigit(sentence.charAt(i)))
				return false;
		}
		return true;
	}
	
	public static String [] total_words(String sentence) {
		String delimiters = "\\s+|,\\s*|\\.\\s*";
		String [] words = sentence.split(delimiters);
		out.println("Numero total de palavras: " + words.length);
		return words;
	}
	
	public static String trade(String sentence) {
		char [] array = sentence.toCharArray();
		for (int i = 0; i < array.length-1;i = i + 2) {
			char c = array[i];
			array[i] = array[i+1];
			array[i+1] = c;
		}
		return String.valueOf(array);
	}

}
