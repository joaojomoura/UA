package aula1.ex2;
import java.util.*;
import static java.lang.System.*;
/**
 * @author slowbro
 *
 */
public class Menu {

	/**
	 * @param args
	 */
	final static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * funcionamento do menu com as varias opçoes, se a opçao for 0 o programa termina
		 */
		int op = 0;
		menu();
		do {
			try {
				op = read_user();
			}
			catch (InputMismatchException e) {
				out.println("Só numeros numericos");
				op = 0;
			}
			finally {
				switch(op) {
					case 1:
						Person person = Person_list.human();
						Person_list.add_Person(person);
						
						break;
					case 2:
						Person_list.showList();
						break;
					case 3:
						out.print("Numero de cc da pessoa a remover: ");
						int toremove = in.nextInt();
						Person_list.remove_Person(Person_list.get_person_by_cc(toremove));
						break;
					case 4:
						out.println("Ordenar por cc");
						Person_list.sort_by_cc();
						Person_list.showList();
						break;
					case 5:
						out.println("Ordenar por nome");
						Person_list.sort_by_name();
						Person_list.showList();
						break;
					case 6:
						menu();
						break;
					case 0:
						out.println("Terminar programa");
						break;
					default:
						out.println("opçao errada!!");
						break;
				}
			}
		}while(op != 0 && op == (int)op );
		

	}
	
	/**
	 * Formato do menu
	 */
	public static void menu() {
		out.println("MENU");
		out.println("1 - Inserir Pessoa nova");
		out.println("2 - Mostrar lista");
		out.println("3 - Remove pessoa");
		out.println("4 - Ordena por CC");
		out.println("5 - Ordena por Nome");
		out.println("6 - Apresentar Menu");
		
	}
	/**
	 * 
	 * @return numero dado por user
	 */
	public static int read_user() {
		int num = 0;
		do {
		out.print("Opção: ");
		num  = in.nextInt();
		}while(num < 0);
		return num;
	}
		

}
