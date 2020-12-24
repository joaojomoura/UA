/**
 * 
 */
package aula5.ex3;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author João Moura
 *
 */
public class Ex3 {

	/**
	 * @param args
	 */
	final static Scanner sc = new Scanner (System.in);
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int opt = 0;
		String file;
		Agenda agenda = new Agenda();
		menu();
		do {
			System.out.print("Opção -> ");
			opt = sc.nextInt();
			
			
			switch(opt) {
				case 0: 
					System.out.println("A terminar programa...."); 
					break;
				case 1:
					agenda.adicionarContato();
					System.out.println("Contacto adicionado");
					break;
				case 2:
					sc.nextLine();
					System.out.print("Nome do ficheiro: ");
					file = sc.nextLine();
					agenda.adicionarDeUmFicheiro(file);
					break;
				case 3:
					sc.nextLine();
					System.out.print("Nome do ficheiro: ");
					file = sc.nextLine();
					agenda.guardarFicheiro(file);
					break;
				case 4:
					agenda.printContatos();
					break;
				default:
					System.out.println("Opcao errada!!");
					break;
				
			}
			
		}while(opt != 0);
		
		System.out.println();
		System.out.println();
		Eliminar.newMenu();
		
		

	}
	
	public static void menu() {
		System.out.println("------------Menu------------");
		System.out.println("1 - Adicionar Contactos");
		System.out.println("2 - Carregar Contactos de um Ficheiro");
		System.out.println("3 - Guardar Contactos num Ficheiro");
		System.out.println("4 - Imprimir no ecra Contactos");
		System.out.println("0 - Termina Programa");
		
	}

}
