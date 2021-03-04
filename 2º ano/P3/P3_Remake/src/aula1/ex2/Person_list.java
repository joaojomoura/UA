/**
 * 
 */
package aula1.ex2;

import static java.lang.System.out;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author slowbro
 *
 */
public class Person_list {
	static Scanner in = new Scanner(System.in);
	private static Set <Pessoa> list = new HashSet<>();;
	
	
	public static Data user_data() {
		boolean valid = false;
		Data d = null;
		while(!valid) {
			try {
			out.println("Data de nascimento");
			out.print("Dia: ");
			int dia = in.nextInt();
			out.print("Mes: ");
			int mes = in.nextInt();
			out.print("Ano: ");
			int ano = in.nextInt();
			in.nextLine();
			d = new Data(dia,mes,ano);
			valid = true;
			} catch(NumberFormatException e) {
				out.println("Data Invalida");
			}
		}
		return d;
	}
	
	public static Pessoa human() {
		Pessoa p = null;
		boolean valid = false;
		while(!valid) {
			try {
				out.print("Nome: ");
				String nome = in.nextLine();
				out.print("Numero de cc: ");
				int cc = in.nextInt();
				
				p = new Pessoa(nome,cc,user_data());
				valid = true;
			}
			catch (NumberFormatException e){
				out.printf("Colocadas letras onde deviam de estar números");
			}
			catch(RuntimeException e) {
				out.println("Nome ou cc invalido");
			}
		}
		return p;
	}
	public static void add_Person(Pessoa p) {
		
		if(list.add(p)) {
			System.out.println("Inserido!");
		}
		else
			System.out.println("Ja existe essa pessoa");
	}
	
	public static void showList() {
		Iterator<Pessoa> i= list.iterator();
		while(i.hasNext())
			System.out.println(i.next());
	}

}
