package aula01;
import java.util.Scanner;


public class Exerc2 {

	static Agenda agenda = new Agenda();
	final static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {

		int op;
		
		while(true){
			op=menu();
			switch(op){
			case 0:	System.exit(0);	break;			
			case 1: inserir(); break;
			case 2: elimina(); break;
			case 3: agenda.imprime(); break;
			case 4: agenda.ordenaNome();break;
			case 5: agenda.ordenaBI();break;
				
			}
			
			
		}
		
		
	
	}
	
	static int menu(){
		
		int op;
		System.out.println();
		System.out.println("1 - Inserir pessoa");
		System.out.println("2 - Apagar Pessoa");
		System.out.println("3 - Apresentar Lista");
		System.out.println("4 - Ordenar pelo Nome");
		System.out.println("5 - Ordenar pelo BI");
		System.out.println("0 - Sair");
		System.out.println("Opção: ");
		do{
		op=s.nextInt();
		}while(op<0 || op>5);
		return op;
	}
	
	
	static void inserir(){
		Scanner s = new Scanner(System.in);
		String nome;
		int BI;
		Data dataNasc;
		int dia, mes, ano;

		
		
		System.out.println("Nome: ");
		nome = s.nextLine();
		
		System.out.println("Número BI: ");
		BI = s.nextInt();
		
		System.out.println("Data de Nascimento: ");
		
		do{
		System.out.println("Dia: ");
		dia = s.nextInt();
		
		System.out.println("Mês: ");
		mes = s.nextInt();
		
		System.out.println("Ano: ");
		ano = s.nextInt();
		
		
		if(!Data.eValida(dia, mes, ano))
			System.out.println("Data incorrecta, por favor reinsira novamente");
		}while(!Data.eValida(dia, mes, ano));
		
		
		dataNasc = new Data(dia, mes, ano);
		
		agenda.inserir(nome, BI, dataNasc);
		
	}
	
	static void elimina(){
		Scanner s = new Scanner(System.in);
		
		System.out.println("Nome Apagar:");
		String tmp = s.nextLine();
		agenda.apagar(tmp);
		
	}
	

}

