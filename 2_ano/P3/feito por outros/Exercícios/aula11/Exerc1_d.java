package aula11;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Exerc1_d extends StringComparator{
	
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
			
			TreeMap<String, Integer> tm = new TreeMap<String, Integer>(new StringComparator());
			Scanner scf = new Scanner(ficheiro);
			
			while(scf.hasNext()) {
				String temp = scf.next();
				if (tm.containsKey(temp)) {
					tm.put(temp, tm.get(temp)+1);
				}
				else {
					tm.put(temp, 1);
				}
			}
			
			Set<Entry<String, Integer>> set = tm.entrySet();
			Iterator<Entry<String, Integer>> it = set.iterator();
			
			while(it.hasNext()) {
				Entry<String, Integer> temp = it.next();
				String aux = temp.getKey();
				
				if(aux.length()<8) {
					System.out.println(temp.getKey()+"\t\t"+temp.getValue());
				}
				else {
					System.out.println(temp.getKey()+"\t"+temp.getValue());
				}
			}
		}
	}
}
