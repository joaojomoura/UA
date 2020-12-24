/**
 * 
 */
package aula7.ex1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

/**
 * @author João Moura
 *
 */
public class LerCompanhias {
	/**
	 * Hashmap para guardar a lista de companhias com a sigla como chave
	 */
	private HashMap<String, Companhia> lerCompanhias;
	
	/**
	 * @Construtor
	 * @param companhiaFile
	 * @throws IOException
	 * Recebe o ficheiro a ler e preenche o hashmap com as linhas de texto
	 */
	public LerCompanhias (String companhiaFile) throws IOException {
		Path file = Paths.get(companhiaFile);
		List<String> lines = Files.readAllLines(file); 
		lerCompanhias = new HashMap<>();
		for(String line : lines) {
			if(line.equals("Sigla\tCompanhia")) {
				
			}
			
			else {
				String[] tmp = line.split("\t");
				lerCompanhias.put(tmp[0], new Companhia(tmp[0],tmp[1]));
			}
		}
		
	}
	
	/**
	 * 
	 * @return array do hashmap
	 */
	public Companhia[] getCompanhias() {
		return (lerCompanhias.values().toArray(new Companhia[lerCompanhias.size()]));
	}
	
	/**
	 * 
	 * @param sigla
	 * @return companhia baseado na sigla
	 */
	public Companhia getCompanhia(String sigla) {
		return lerCompanhias.get(sigla);
	}
}
