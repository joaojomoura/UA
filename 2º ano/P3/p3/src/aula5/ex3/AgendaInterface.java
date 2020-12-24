/**
 * 
 */
package aula5.ex3;

import java.io.*;
import java.util.*;


/**
 * @author João Moura
 *
 */
public interface AgendaInterface {
	abstract void save(File file, Contato [] c) throws IOException;
	abstract ArrayList<Contato> load(Scanner file) throws IOException;
}
