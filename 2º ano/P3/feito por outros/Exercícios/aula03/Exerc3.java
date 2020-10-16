package aula03;
import java.util.*;

public class Exerc3 {
	final static Scanner scan = new Scanner(System.in);
	static Install ins =instalacao();
	static Videoclube videoclube = new Videoclube(ins.nCl,ins.nVi);
	public static void main(String[] args)

	{ 
		menu(cabecalho());
		
	
		
	}
	
	public static void menu(int opcao)
	{
		System.out.println();
		switch(opcao)
		{ 
			case 1:
				clear();
				menuVideos(cabV());
				break;
			case 2:
				clear();
				menuClientes(cabC());
				break;
			case 3:
				clear();
				menuAluguer(cabA());
				break;
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("Não foi escolhida uma opção válida");
				clear();
				menu(cabecalho());
				break;
		
		
		}
		
		
	}
	
	public static void menuVideos(int opcao)
	{ 
		
		
		switch(opcao)
		{ 
			case 1:
				System.out.println(videoclube.adicionarVideo(leVideo()));
				clear();
				menuVideos(cabV());
				break;
				
			case 2:
				System.out.println(videoclube.removerVideo(leIdVideo()));
				clear();
				menuVideos(cabV());
				break;
				
			case 3:
				System.out.println(videoclube.encontrarVideo(leIdVideo()));
				clear();
				menuVideos(cabV());
				break;
				
			case 4:
				System.out.println(videoclube.editarVideo(leIdVideo(),leCopia()));
				clear();
				menuVideos(cabV());
				break;
				
			case 5:
				System.out.println(videoclube.listarVideos());
				clear();
				menuVideos(cabV());
				break;
				
			case 6:
				System.out.println(videoclube.imprimeRating(leIdVideo()));
				clear();
				menuVideos(cabV());
				break;
				
			case 7:
				clear();
				menu(cabecalho());
				break;
				
			case 8:
				System.exit(0);
				break;
				
			default:
				System.out.println("Não foi escolhida uma opção válida");
				clear();
				menuVideos(cabV());
				break;
		
		
		
		}
	}
	
	public static void menuClientes(int opcao)
	{ 
		switch(opcao)
		{ 
			case 1:
				System.out.println(videoclube.adicionarCliente(leCliente()));
				clear();
				menuClientes(cabC());
				break;
				
			case 2:
				System.out.println(videoclube.removerCliente(leIdCliente()));
				clear();
				menuClientes(cabC());
				break;
				
			case 3:
				System.out.println(videoclube.encontrarCliente(leIdCliente()));
				clear();
				menuClientes(cabC());
				break;
				
			case 4:
				System.out.println(videoclube.listarClientes());
				clear();
				menuClientes(cabC());
				break;
			
			case 5:
				clear();
				menu(cabecalho());
				break;
				
			case 6:
				System.exit(0);
				break;
				
			default:
				System.out.println("Não foi escolhida uma opção válida");
				clear();
				menuClientes(cabC());
				break;
				
		
		}
		
		
		
	}
	
	public static void menuAluguer(int opcao)
	{ 
		switch(opcao)
		{ 
			case 1:
				System.out.println(videoclube.alugarVideo(leIdCliente(), leIdVideo()));
				clear();
				menuAluguer(cabA());
				break;
				
			case 2:
				System.out.println(videoclube.devolverVideo(leIdCliente(), leIdVideo(), leRating()));
				clear();
				menuAluguer(cabA());
				break;
			
			case 3:
				System.out.print(videoclube.historico(leIdCliente()));
				clear();
				menuAluguer(cabA());
				break;
				
			case 4:
				System.out.println(videoclube.videosDA());
				clear();
				menuAluguer(cabA());
				break;
				
			case 5:
				clear();
				menu(cabecalho());
				break;
				
			case 6:
				System.exit(0);
		
		
		}
		
		
		
	}
		
		
		
		
		
		
		
	
	
	public static int cabecalho()
	{ 
		int i;
		String x="";
		String vc = "VideoClube " + ins.nome;
		x = x + "|";
		if(ins.nome.length()%2==0)
			i = 22;
		else
			i = 23;
		for(int k=0;k<23-(vc.length()/2);k++)
			x = x +" ";
			
		x = x + vc;
		for(int k=0;k<i-(vc.length()/2);k++)
			x = x +" ";
			
		x = x +"| \n";

		
			System.out.println(" ----------------------------------------------");
			System.out.println("|                                              |");
			System.out.print(x);
			System.out.println("|                                              |");
			System.out.println(" ----------------------------------------------");
			System.out.println("| 1. Gerir Videos                              |");
			System.out.println("| 2. Gerir Clientes                            |");
			System.out.println("| 3. Gerir Alugueres                           |");
			System.out.println("| 4. Sair                                      |");
			System.out.println(" ----------------------------------------------");
			System.out.print("Opção: ");
			return scan.nextInt();
			
		
		
		
	}
	public static int cabV()
	{ 
		
		System.out.println(" ----------------------------------------------");
		System.out.println("|                                              |");
		System.out.println("|               Gestão de Videos               |");
		System.out.println("|                                              |");
		System.out.println(" ----------------------------------------------");
		System.out.println("| 1. Adicionar Video                           |");
		System.out.println("| 2. Remover   Video                           |");
		System.out.println("| 3. Pesquisar Video                           |");
		System.out.println("| 4. Editar Video (nº cópias)                  |");
		System.out.println("| 5. Listar Videos                             |");
		System.out.println("| 6. Ver Rating de um Video                    |");
		System.out.println("| 7. Voltar ao menu anterior                   |");
		System.out.println("| 8. Sair                                      |");
		System.out.println(" ----------------------------------------------");
		System.out.print("Opção: ");
		return scan.nextInt();
		
		
		
	}
	
	public static int cabC()
	{ 
		
		System.out.println(" ----------------------------------------------");
		System.out.println("|                                              |");
		System.out.println("|               Gestão de Clientes             |");
		System.out.println("|                                              |");
		System.out.println(" ----------------------------------------------");
		System.out.println("| 1. Adicionar Cliente                         |");
		System.out.println("| 2. Remover   Cliente                         |");
		System.out.println("| 3. Pesquisar Cliente                         |");
		System.out.println("| 4. Listar Clientes                           |");
		System.out.println("| 5. Voltar ao menu anterior                   |");
		System.out.println("| 6. Sair                                      |");
		System.out.println(" ----------------------------------------------");
		System.out.print("Opção: ");
		return scan.nextInt();
		
		
	}
	public static void clear()
	{ 
		System.out.print("\n\n\n\n\n");
		
		
		
	}
	public static Video leVideo()
	{ 	
		System.out.print("Qual o titulo do Video? ");
		scan.nextLine();
		String titulo = scan.nextLine();
		String categoria="";
		String idade="";
		do{
		System.out.print("Qual a sua categoria? ");
		categoria = scan.next();
		}while(!Video.validaCat(categoria));
		scan.nextLine();
		do{
		System.out.print("A que idade se adequa? (TODOS, M6, M12, M16, M18) ");
		idade = scan.next();
		} while(!Video.validaIda(idade));
		scan.nextLine();
		System.out.print("Quantas cópias existem no videoclube? ");
		int copias = scan.nextInt(); 
		System.out.println();
		
		
		return new Video(titulo,categoria,idade,copias);
	}
	
	public static int leIdCliente()
	{ 

	
		System.out.print("Qual o ID do Cliente? ");
		return scan.nextInt();

		
		
		
	}
	public static int leIdVideo()
	{ 
		System.out.print("Qual o ID do Video? ");
		return scan.nextInt();
		
		
	}
	
	public static int leCopia()
	{ 
		System.out.print("Qual o novo numero de Cópias? ");
		int a = scan.nextInt();
		System.out.println();
		if(a<=0)
		{
			System.out.println("Insira um numero válido de cópias");
			leCopia();
		}
		return a;
		
	}
	
	public static Cliente leCliente()
	{ 
		String temp = "estudante || funcionario";
		System.out.print("Qual o tipo de Cliente? (Estudante ou Funcionario) ");
		String a = scan.next();
		a=a.toLowerCase();
		if(temp.indexOf(a)==-1)
		{ 
			System.out.println("Insira um tipo válido de Cliente");
			leCliente();
			
			
		}
		if(a.equals("estudante"))
		{ 
			Estudante est = leEstudante();
			Data agora = new Data();
			
			return new Cliente(est,agora,ins.nViP);
		}
		else
		{ 
			Funcionario func = leFuncionario();
			Data agora = new Data();
			
			return new Cliente(func,agora,ins.nViP);
			
			
		}
		
	}
	
	public static Estudante leEstudante()
	{ 
		Pessoa a = lePessoa();
		System.out.print("Qual o seu numero mecanográfico? ");
		int mec = scan.nextInt();
		System.out.println();
		
		return new Estudante(a.getNome(), a.getBI(), a.getData(),mec);
		
	}
	
	public static Funcionario leFuncionario()
	{ 
		Pessoa a = lePessoa();
		System.out.print("Qual o seu nº Funcionario? ");
		int nFunc = scan.nextInt();
		System.out.println();
		System.out.print("Qual o seu nº Fiscal? ");
		int nFisc = scan.nextInt();
		
		return new Funcionario(a.getNome(), a.getBI(), a.getData(),nFunc,nFisc);
		
	}
	
	public static int cabA()
	{ 
		
		System.out.println(" ----------------------------------------------");
		System.out.println("|                                              |");
		System.out.println("|              Gestão de Alugueres             |");
		System.out.println("|                                              |");
		System.out.println(" ----------------------------------------------");
		System.out.println("| 1. Alugar um Video                           |");
		System.out.println("| 2. Devolver um Video                         |");
		System.out.println("| 3. Histórico de Alugueres por Cliente        |");
		System.out.println("| 4. Videos Disponiveis/Alugados               |");
		System.out.println("| 5. Voltar ao menu anterior                   |");
		System.out.println("| 6. Sair                                      |");
		System.out.println(" ----------------------------------------------");
		System.out.print("Opção: ");
		return scan.nextInt();
		
		
	}
	
	public static int leRating()
	{ 
		System.out.print("Qual o Rating que dá a este video? ");
		int x =scan.nextInt();
		
		if(!Video.validaRating(x))
			leRating();
		
		return x;
	}
	
	public static Install instalacao()
	{ 
		int nCl, nVi, nViP;
			System.out.println(" ----------------------------------------------");
			System.out.println("|                                              |");
			System.out.println("|                  Instalacao                  |");
			System.out.println("|                                              |");
			System.out.println(" ----------------------------------------------");
		
			System.out.print("| Nome do VideoClube: ");
			  String nome = scan.nextLine(); 
			  do{
				  System.out.print("| Nº de Clientes possiveis: ");
				  nCl = scan.nextInt();
			  }while(nCl<=0);
			  
			  do{
				  System.out.print("| Nº de Videos possiveis: ");
				  nVi = scan.nextInt();
			  }while(nVi<=0);
			  
			  do{
				  System.out.print("| Nº de Videos que cada Cliente pode alugar: ");
				  nViP = scan.nextInt();
			  }while(nViP<=0);
			System.out.println(" ----------------------------------------------");
			
		
		
		return new Install(nome,nCl,nVi,nViP);
	}
	public static Pessoa lePessoa()
	{ 
		System.out.print("Qual o nome da Pessoa? ");
		scan.nextLine();
		String nome = scan.nextLine();
		System.out.println();
		System.out.print("Qual o nr BI? ");
		int BI = scan.nextInt();
		System.out.println();
		System.out.println("Data de Nascimento:");
		Data dN = leData();
		
		return new Pessoa(nome,BI,dN);
		
	}
	
	public static Data leData()
	{ 
		Data dN;
		int dia,mes,ano;
		do{
		System.out.print("Qual o dia? ");
		dia = scan.nextInt();
		System.out.println();
		System.out.print("Qual o mes? ");
		mes = scan.nextInt();
		System.out.println();
		System.out.print("Qual o ano? ");
		ano = scan.nextInt();
		scan.nextLine();
		System.out.println();
		dN = new Data(dia,mes,ano);
		
	 }while(!dN.datavalida(dia,mes,ano));
				
			return dN;
		
	}
	

}

class Install
{ 
	String nome;
	int nCl;
	int nVi;
	int nViP;
	
	public Install(String nome, int nCl,int nVi,int nViP)
	{ 
		this.nome = nome;
		this.nCl = nCl;
		this.nVi= nVi;
		this.nViP = nViP;
		
	}
}
