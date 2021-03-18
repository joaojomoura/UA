package aula11;
import java.io.*;
import java.util.*;

public class Exerc1_c {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		if (args.length!=1){
			System.err.println("Não foram encontrados argumentos");
			System.exit(0);
		}
		
		else {
			File directorio = new File("./src/aula11");
			File ficheiro = new File(directorio, args[0]);
			
			if (!ficheiro.exists()) {
				System.err.println("O argumento não existe");
				System.exit(1);
			}
			
			if(ficheiro.isDirectory()) {
				System.err.println("O argumento é um directório");
				System.exit(2);
			}
			
			if(!ficheiro.isFile()) {
				System.err.println("O argumento não é um ficheiro");
				System.exit(3);
			}
			
			if(!ficheiro.canRead()) {
				System.err.println("O ficheiro não tem permissão de leitura");
				System.exit(4);
			}
			
			HashMap<String, Integer> hm = new HashMap<String, Integer>();
			HashSet<String> palavras = new HashSet<String>();
			Scanner scf = new Scanner(ficheiro);
			
			while(scf.hasNext()) {
				String temp = scf.next();
				if (hm.containsKey(temp)) {
					hm.put(temp, hm.get(temp)+1);
				}
				else {
					hm.put(temp, 1);
				}
				palavras.add(temp);
			}
			
			Iterator<String> it = palavras.iterator();
			
			while(it.hasNext()) {
				String temp = it.next();
				char[] c = temp.toCharArray();
				if (c.length <8) {
					System.out.println(temp+"\t\t"+hm.get(temp));
				}
				else {
					System.out.println(temp+"\t"+hm.get(temp));
				}
			}
		}
	}
}
