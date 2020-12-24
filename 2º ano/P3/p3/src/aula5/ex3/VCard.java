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
public class VCard implements AgendaInterface {

	@Override
	public void save(File file, Contato[] c) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter print = new PrintWriter(file);
		print.println("vCard");
		
		for(Contato con: c) {
			print.print("#" + con.nome() + "#");
			print.print(con.getNum() + "#");
			print.println(con.dataNasc());
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
			linha = file.nextLine().split("#");
			numb = Integer.parseInt(linha[2]);
			data = linha[3].split("/");
			l.add(new Contato(linha[1], numb, new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]))));
		}
		return l;
	}

}
