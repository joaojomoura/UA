/**
 * 
 */
package aula1.ex2;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * @author slowbro
 *
 */
public class Person_list {
	static Scanner in = new Scanner(System.in);
	private static List <Person> list = new ArrayList<>();;
	

	public static Data user_data() {
		boolean valid = false;
		Data d = null;
		while(!valid) {
			try {
			out.println("Data de nascimento");
			out.print("Dia: ");
			var dia = in.nextInt();
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
	
	public static Person human() {
		Person p = null;
		boolean valid = false;
		while(!valid) {
			try {
				out.print("Nome: ");
				String nome = in.nextLine();
				out.print("Numero de cc: ");
				int cc = in.nextInt();
				
				p = new Person(nome,cc,user_data());
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
	
	public static void add_Person(Person p) {
	
		
		if(!list.contains(p)) {
			list.add(p);
			System.out.println("Inserido!");
		}
		else
			System.out.println("Ja existe essa pessoa");
	}
	
	public static void showList() {
		Iterator<Person> i= list.iterator();
		while(i.hasNext())
		out.println(i.next());
	}
	
	
	
	public static Person get_person_by_cc(int cc) {
		Optional<Person> p= list.stream()
				.filter(person -> cc ==(person.getCc()))
				.findAny();
		return p.get();
	}
	
	public static void remove_Person(Person p) {
		if(list.remove(p))
			out.println("Removido");
	}
	
	
	
	
	public static void sort_by_name() {
		list.sort(Comparator.comparing(Person::getName));
	}
	public static void sort_by_cc() {
		list.sort(Comparator.comparing(Person::getCc));
	}

}
