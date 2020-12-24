/**
 * 
 */
package aula7.ex1;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author João Moura
 *
 */
public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		ListadeVoos lista = new ListadeVoos("voos.txt","companhias.txt");
		lista.printScreen();
		lista.printDelayAverage();
		lista.saveCity();
		lista.saveAllBin();
		lista.readBin();
		
		

	}

}
