package aula12;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Exerc3 {
	public static Map<String, TreeMap<String, Integer>> map;
	
	public static void main (String[] args) throws IOException {
		
		if (args.length!=1){
			System.err.println("Não foram encontrados argumentos");
			System.exit(0);
		}
		
		else {
			File directorio = new File("./src/aula12");
			File ficheiro = new File(directorio, args[0]);
			map = new TreeMap<String, TreeMap<String, Integer>>();
			
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
			
			Scanner scf = new Scanner(ficheiro).useDelimiter("[-_<>«»@#£$§€%&+*.,:'‘’;?!*{}=+&/()”“\"\'\\s\t\r\n]+");
			TreeMap<String, Integer> temp;
			String palavraActual = null, palavraAnterior = null;
			
			while (scf.hasNext()) {
				palavraActual = palavraAnterior;
				
				do {
					palavraAnterior = scf.next().toLowerCase();
				} while(scf.hasNext() && palavraAnterior.length() < 3);
				
				if (palavraActual!=null) {
					if (map.containsKey(palavraActual)) {
						temp = map.get(palavraActual);
						if (temp.containsKey(palavraAnterior)) {
							temp.put(palavraAnterior, temp.get(palavraAnterior)+1);
						}
						else {
							temp.put(palavraAnterior, 1);
						}
					}
					else {
						temp = new TreeMap<String, Integer>();
						temp.put(palavraAnterior, 1);
						map.put(palavraActual, temp);
					}
				}
			}

			scf.close();
			escreveNoFicheiro();
		}
	}
	
	private static void escreveNoFicheiro() throws FileNotFoundException {
		File directorio = new File("./src/aula12");
		File out = new File(directorio, "output.txt");

		PrintWriter pwd = new PrintWriter(out);
		Set<Entry<String, TreeMap<String, Integer>>> set = map.entrySet();
		java.util.Iterator<Entry<String, TreeMap<String, Integer>>> it = set.iterator();
			
		while(it.hasNext()) {
			Entry<String, TreeMap<String, Integer>> aux = it.next();
			pwd.println(aux.getKey() + "=" + aux.getValue());
		}
		pwd.close();
		System.out.println("Ficheiro 'output.txt' criado!");
	}
	
	
//	public static void escreveNoFicheiro() throws FileNotFoundException {
//		File directorio = new File("./src/aula12");
//		File out = new File(directorio, "output.txt");
//		
//		PrintWriter pwd = new PrintWriter(out);
//		pwd.println(map);
//		pwd.close();
//		System.out.println("Ficheiro 'output.txt' criado!");
//	}
}
