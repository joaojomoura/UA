package aula01;
import java.util.*;

public class Exerc1 {
	
	public static void main (String[] args) {
		
		String stdin;
		String stdout;
		Scanner in = new Scanner (System.in);
		
		System.out.println("Insira a palavra!");
		stdin = in.nextLine();
		stdout = inverte(stdin);

		System.out.println(stdin);
		System.out.println(stdout);
				
		
		if (stdin.equalsIgnoreCase(stdout)) {
			System.out.println("A palavra é palíndrome!");
		}
		else {
			System.out.println("A palavra não é palíndrome!");
		}
	}
	
	public static String inverte(String s) {
		char [] a = s.toCharArray();
		
		
		String out= "";
		
		for (int i = a.length-1; i>=0; i--) {
			out= out + "" + a[i];
		}
		
		
		return out;
	}
}