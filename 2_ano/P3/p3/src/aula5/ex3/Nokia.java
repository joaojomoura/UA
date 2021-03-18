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
public class Nokia implements AgendaInterface {

	@Override
	public void save(File file, Contato[] c) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter print = new PrintWriter(file);
		print.println("Nokia");
		
		for(Contato con: c) {
			print.println(con.nome());
			print.println(con.getNum());
			print.println(con.dataNasc());
			print.println();
		}
		
		
		print.close();
	}

	@Override
	public ArrayList<Contato> load(Scanner file) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Contato> l = new ArrayList<Contato>();
		String nome;
		int numb;
		String data[];
		while (file.hasNextLine())
		{
			nome = file.nextLine();
			numb = Integer.parseInt(file.nextLine());
			data = file.nextLine().split("/");
			l.add(new Contato(nome, numb, new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]))));
			if (file.hasNextLine())
				file.nextLine();
			
		}
		return l;
	}

}
