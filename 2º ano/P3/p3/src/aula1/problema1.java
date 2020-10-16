/**
 * 
 */
package aula1;

/**
 * problema 1.1 do guiao 1
 * @author João Moura
 *
 */
import static java.lang.System.*;
import java.util.Scanner;

public class problema1 {
	
	/**
	 * programa principal
	 * @param args
	 */
	final static Scanner in = new Scanner (System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sentence = read_user();
		out.printf("Foram lidos %d numeros%n",count_numbers(sentence));
		min_char(sentence);
		max_char(sentence);
		number_words(sentence);
		switch_letters(sentence);
	}
	
	/**
	 * 
	 * @return {@code String} String dada por user.
	 */
	public static String read_user() {
		String sentence = new String();
		out.print("Frase: ");
		sentence = in.nextLine();
		return sentence;
	}
	/**
	 * 
	 * @param s
	 * @return {@code int} Numero de ocorrencias de numeros na string
	 */
	public static int count_numbers (String s) {
		int count = 0;
		for(int i = 0; i < s.length();i++) {
			if(Character.isDigit(s.charAt(i)))
				count++;
		}
		return count;
	}
	/**
	 * Verifica se a frase é constituida por minusculas
	 * @param s
	 */
	public static void min_char (String s) {
		for(int i = 0; i < s.length(); i++) {
			if(Character.isUpperCase(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
				out.println("Tem pelo menos uma Maiuscula ou numero");
				return;
			}	
		}
		out.println("Constituido só por minusculas");
	}
	
	/**
	 * Verifica se a frase é constituida por maiusculas
	 * @param s
	 */
	public static void max_char (String s) {
		for(int i = 0; i < s.length(); i++) {
			if(Character.isLowerCase(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
				out.println("Tem pelo menos uma Minuscula ou numero");
				return;
			}	
		}
		out.println("Constituido só por maiuscula");
	}
	/**
	 * Le o numero de palavras numa frase
	 * @param s
	 */
	public static void number_words(String s) {

		String delimiters = "\\s+|,\\s*|\\.\\s*";
		String [] words = s.split(delimiters);
		out.println("Numero de palavras: " + words.length);
	}
	
	
	/**
	 * troca de duas em duas as letras da string
	 * @param s
	 */
	public static void switch_letters(String s) {
		
		char ch[] = s.toCharArray();
		for(int i = 0;i < (ch.length-1);i+=2) {
			char tmp = ch[i];
			ch[i] = ch[i+1];
			ch[i+1] = tmp;
		}
		out.println(String.valueOf(ch));
	}
}
