/**
 * 
 */
package aula5.ex3;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import aula1.ex2.Data;

/**
 * @author João Moura
 *
 */
public class CSV implements AgendaInterface {

	@Override
	public void save(File file, Contato[] c) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter print = new PrintWriter(file);
		print.println("CSV");
		
		for(Contato con: c) {
			print.print(con.nome() + "\t");
			print.print(con.getNum() + "\t");
			print.println(con.dataNasc() + "\t");
		}
		
		
		print.close();

	}

	@Override
	public ArrayList<Contato> load(Scanner file) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Contato>l = new ArrayList<Contato>();
		String linha[];
		int numb;
		String data[];
		while (file.hasNextLine())
		{
			linha = file.nextLine().split("\t");
			numb = Integer.parseInt(linha[1]);
			data = linha[2].split("/");
			l.add(new Contato(linha[0], numb, new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]))));
		}
		return l;
	}

}
