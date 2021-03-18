package aula11;
import java.io.*;
import java.util.*;

public class Exerc1_b {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		if (args.length!=1){
			System.err.println("N�o foram encontrados argumentos");
			System.exit(0);
		}
		
		else {
			File directorio = new File("./src/aula11");
			File ficheiro = new File(directorio, args[0]);
			HashSet<String> hs = new HashSet<String>();
			
			if (!ficheiro.exists()) {
				System.err.println("O argumento n�o existe");
				System.exit(1);
			}
			
			if(ficheiro.isDirectory()) {
				System.err.println("O argumento � um direct�rio");
				System.exit(2);
			}
			
			if(!ficheiro.isFile()) {
				System.err.println("O argumento n�o � um ficheiro");
				System.exit(3);
			}
			
			if(!ficheiro.canRead()) {
				System.err.println("O ficheiro n�o tem permiss�o de leitura");
				System.exit(4);
			}
			
			int cont = 0;
			Scanner scf = new Scanner(ficheiro);
			
			while (scf.hasNext()) {
				String temp = scf.next();
				hs.add(temp);
				cont++;
			}
			
			System.out.println("N�mero total de palavras: "+cont);
			System.out.println("N�mero de diferentes palavras: "+hs.size());
		}
	}
}
