/**
 * 
 */
package aula1.ex2;
import java.util.*;
import static java.lang.System.*;


/**
 * @author João Moura
 *
 */
public class list_person {
	
	private final static Scanner in = new Scanner(System.in);
	
	//Criaçao de uma lista com pessoas
	private static List<Pessoa> lista = new ArrayList<Pessoa>();
	
	
	/**
	 * 
	 * @return data de nascimento
	 */
	public static Data dNas() {
		Data d = null;
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
		
		} 
		catch (NumberFormatException e){
			out.printf("Colocadas letras onde deviam de estar números");
		}
		catch(RuntimeException e) {
			out.println("Data Invalida");
		}
		
		return d;
	}
	
	
	
	/**
	 * 
	 * @param d
	 * recebe a data de nascimento
	 * @return e retorna a pessoa nova
	 */
	public static Pessoa human() {
		Pessoa p = null;
		try {
			out.print("Nome: ");
			String nome = in.nextLine();
			out.print("Numero de cc: ");
			int cc = in.nextInt();
			
			p = new Pessoa(nome,cc,dNas());
		}
		catch (NumberFormatException e){
			out.printf("Colocadas letras onde deviam de estar números");
		}
		catch(RuntimeException e) {
			out.println("Nome ou cc invalido");
		}
		return p;
	}
	
	
	
	
	/**
	 * Acrescenta pessoas à lista
	 * se já houver alguem com o numero cc repetido, termina
	 */
	public static void addPerson (Pessoa newp) {
		if(!lista.isEmpty() && newp != null)
			for(int i = 0; i <lista.size();i++) {
				Pessoa p = lista.get(i);
				if(p.cc() != newp.cc()) {
					lista.add(newp);
					out.printf("Inserido%n%n");
				}
				else {
					out.println("Já existe esse cc");
					break;
				}
					
			}
		else if (newp != null){	
			lista.add(newp);
			out.printf("Inserido%n%n");
		}
	}
	
	
	
	/**
	 * Mostra a lista de pessoas
	 */
	public static void showList() {
		try {
			if(lista.isEmpty())
				out.println("Lista Vazia");
			else {
				out.println("-----Lista de pessoas-----");
			for (int i = 0; i < lista.size(); i++) {
	            Pessoa p = lista.get(i);
	            out.printf("%d - %s%ncc- %d%nData de Nascimento: %d/%d/%d%n%n", i+1,p.nome(),p.cc(),p.dataNasc().dia(),
	            		p.dataNasc().mes(),p.dataNasc().ano());
			}
			}
		}
		catch(NullPointerException e) {
			out.println("Lista Vazia. Insira uma pessoa");
		}	
	}
	
	
	
	/**
	 * recebe 
	 * @param toremove (numero de cc para remover)
	 * compara com os da lista e remove da lista essa pessoa
	 */
	public static void removePerson(int toremove) {
		if(lista.isEmpty())
			out.println("Nada a remover, a lista está vazia");
		for (int i = 0; i < lista.size(); i++) {
            Pessoa p = lista.get(i);
            if(p.cc() == toremove) {
            	lista.remove(i);
            	out.printf("Removido %s%n%n", p.nome());
            }
            else 
            	out.printf("Não existe ninguem com o cc %d%n", toremove);         
		}
	}
	
	
	
	/**
	 * ordena por cc
	 */
	public static void sortByCC () {	
		lista.sort(Comparator.comparing(Pessoa::cc));
	}
	
	
	/**
	 * ordena por nome
	 */
	public static void sortByName() {
		lista.sort(Comparator.comparing(Pessoa::nome));
	}
}
