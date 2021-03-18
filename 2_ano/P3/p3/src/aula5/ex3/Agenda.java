/**
 * 
 */
package aula5.ex3;

import java.util.*;
import java.io.*;
import aula1.ex2.*;


/**
 * @author João Moura
 *
 */
public class Agenda {
	
	//atributos
	private List <Contato> contatos;
	private Scanner scan;
	private AgendaInterface agenda;
	
	
	//Construtor
	public Agenda() {
		contatos = new ArrayList <Contato> ();
	}
	
	public void adicionarContato() {
		try {
			Contato c;
			scan = new Scanner(System.in);
			System.out.print("Nome: ");
			String nome = scan.nextLine();
			System.out.print("Numero: ");
			int num = scan.nextInt();
			System.out.print("Dia: ");
			int dia = scan.nextInt();
			System.out.print("Mes: ");
			int mes = scan.nextInt();
			System.out.print("Ano: ");
			int ano = scan.nextInt();
			c = new Contato(nome, num, new Data(dia,mes,ano));
			contatos.add(c);
			
			
		}
		catch(InputMismatchException e) {
			System.out.println("Numeros onde deviam estar letras ou vice-versa");
			
		}
		catch(RuntimeException e) {
			System.out.println("Data invalida");
		}
	}
	
	public void guardarFicheiro (String filename) throws IOException{
		
		scan = new Scanner(System.in);
		System.out.print("Tipo de Contacto: ");
		String tipo = scan.nextLine();
		
		if(tipo.equalsIgnoreCase("nokia"))
			agenda = new Nokia();
		else if(tipo.equalsIgnoreCase("csv"))
			agenda = new CSV();
		else if(tipo.equals("vcard"))
			agenda = new VCard();
		else
			throw new IllegalArgumentException("Tipo de ficheiro errado");
		
		agenda.save(new File(filename), contatos.toArray(new Contato[contatos.size()]));
		
	}
	
	public void adicionarDeUmFicheiro(String filename) throws IOException
	{
		
		try
		{
			scan = new Scanner(new File(filename));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("ficheiro não encontrado");
			return;
		}
		String type = scan.nextLine();
		if (type.equalsIgnoreCase("nokia"))
		{
			agenda = new Nokia();
		}
		else if (type.equalsIgnoreCase("CSV"))
		{
			agenda = new CSV();
		}
		else if (type.equalsIgnoreCase("vCard"))
		{
			agenda = new VCard();
		}
		else
		{
			throw new IllegalArgumentException("Tipo de ficheiro errado");
		}
		contatos.addAll(agenda.load(scan));
	}
	
	public void printContatos() {
		
		Iterator <Contato> i = contatos.iterator();
		Contato c;
		while(i.hasNext()) {
			c = i.next();
			System.out.println(c);
		}
	}

}
