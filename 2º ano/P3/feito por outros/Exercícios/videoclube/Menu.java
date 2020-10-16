package videoclube;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		int op, opcao;
		CatalogoDeVideos listaVideos = new CatalogoDeVideos(20);
		CatalogoDeUtilizadores listaUtilizadores = new CatalogoDeUtilizadores(20);
		CatalogoDeEmprestimos listaEmprestimos=new CatalogoDeEmprestimos(20);
		Scanner scan = new Scanner(System.in);
		Scanner scans = new Scanner(System.in);

		do {
			op = menuPrincipal();

			switch (op) {

			case 1:
				do {
					opcao = menuVideos();
					if (opcao == 1) {
						String titulo;
						String s;
						Categoria categoria;
						Idade idd;
						int ID = listaVideos.getnumV();

						System.out.println("Titulo: ");
						titulo = scans.nextLine();
						do{
							System.out.println("Categoria (Acção, Comédia, Infantil, Drama): ");
							s = scans.nextLine();
						}while (!(s.equals("Acção") || s.equals("Comédia") || s.equals("Infantil") || s.equals("Drama")));
						if (s.equals("Acção"))
							categoria = Categoria.Acção;
						else if (s.equals("Comédia"))
							categoria = Categoria.Comédia;
						else if (s.equals("Infantil"))
							categoria = Categoria.Infantil;
						else
							categoria = Categoria.Drama;
						
						//do{
						System.out.println("Idade");
						s = scans.nextLine();
						//} while ()
						idd=Idade.ALL;
							
						listaVideos.adicionar(new Video(ID, titulo, categoria,idd));
					}

					if (opcao == 2) {
						int ID;
						System.out.println("Indique o ID do video a apagar: ");
						ID = scan.nextInt();
						listaVideos.delete(ID);
					}

					if (opcao == 3) {
						String s;
						System.out
								.println("Escrava o titulo do video que quer procurar: ");
						s = scans.nextLine();
						listaVideos.procurarTitulo(s);
					}

					if (opcao == 4) {
						listaVideos.imprimirV();
					}

				} while (opcao != 5);
				break;
			case 2:
				do {
					opcao = menuUtilizadores();

					if (opcao == 1) {
						Pessoa u;
						Utilizador ut;
						int tipo;
						System.out.println("Tipo de sócio (1-Funcionário, 2-Estudante): ");
						tipo = scan.nextInt();
						if (tipo == 1) {
							u = new Funcionario();
							Data validarData = new Data(1, 1, 1);

							System.out.println("Nome: ");
							u.setNome(scans.nextLine());
							System.out.println("BI: ");
							u.setBi(scan.nextInt());
							System.out.println("Data de Nascimento: ");

							validarData.lerData();
							u.setDataNasc(validarData);

							System.out.println("Numero Mec: ");
							((Funcionario) u).setnumFunc(scan.nextInt());
							System.out.println("Nif: ");
							((Funcionario) u).setnif(scan.nextInt());

						} else {
							u = new Estudante();

							Data validarData = new Data(1, 1, 1);

							System.out.println("Nome: ");
							u.setNome(scans.nextLine());
							System.out.println("BI: ");
							u.setBi(scan.nextInt());
							System.out.println("Data de Nascimento: ");

							validarData.lerData();
							u.setDataNasc(validarData);

							System.out.println("Numero Mecanográfico: ");
							((Estudante) u).setnumMec(scan.nextInt());
							System.out.println("Curso: ");
							((Estudante) u).setcurso(scans.nextLine());
						}
						ut = new Utilizador(u);
						listaUtilizadores.adicionar(ut);

					}
					
					else if (opcao == 2) {
						
						int iBI;
						System.out.print("Qual o número do BI do utilizador que pretende apagar? ");
						
						iBI = scan.nextInt();
						listaUtilizadores.delete(iBI);
					}
					
					else if (opcao == 3) {
						listaUtilizadores.imprimirU();
					}

				} while (opcao != 4);
				break;

			case 3:
				do {
					opcao = menuEmprestimos();
					if(opcao==1)
					{
						int idu;
						System.out.println("Qual é o número de sócio?");
						idu=scan.nextInt();
						listaEmprestimos.imprimirEmpU(idu);
						
					}else if(opcao==2)
					{
						int idv,idu;
						System.out.println("ID do video: ");
						idv = scan.nextInt();
						System.out.println("ID do utilizador: ");
						idu=scan.nextInt();
						
						listaEmprestimos.checkIn(idv, idu, listaVideos);
						
					}else if(opcao==3)
					{
						int idv,idu;
						System.out.println("ID do video: ");
						idv = scan.nextInt();
						System.out.println("ID do utilizador: ");
						idu=scan.nextInt();
						
						listaEmprestimos.checkOut(idv, idu, listaVideos);
						
					}else if(opcao==4)
					{
						int idv;
						System.out.println("Qual é ID do video?");
						idv=scan.nextInt();
						listaEmprestimos.imprimirEmpU(idv);
						
					}else if(opcao==5)
					{
						int idv;
						System.out.println("Qual o ID do video?");
						idv=scan.nextInt();
						listaVideos.imprimirDisp(idv);
					}
					
				} while (opcao != 6);
				break;

			}
		} while (op != 0);

	}


	public static int menuPrincipal() {
		Scanner in = new Scanner(System.in);

		int opcao;
		System.out.println();
		System.out.println("-----------Video Clube-----------");
		System.out.println();
		System.out.println("1 - Gestão do Catálogo de Videos.");
		System.out.println("2 - Gestão de Utilizadores.");
		System.out.println("3 - Gestão de Empéstimos.");
		System.out.println("0 - Sair.");
		System.out.println();

		do {
			System.out.println("Opção --> ");
			opcao = in.nextInt();
		} while (opcao > 3 || opcao < 0);
		return opcao;
	}

	public static int menuVideos() {
		Scanner in = new Scanner(System.in);
		int opcao;

		System.out.println();
		System.out.println("    Catálogo de Videos");
		System.out.println();
		System.out.println("1 - Adicionar Video.");
		System.out.println("2 - Apagar Video.");
		System.out.println("3 - Procurar Título.");
		System.out.println("4 - Listar todos os Videos.");
		System.out.println("5 - Voltar");
		System.out.println();
		do {

			System.out.println("Opção --> ");
			opcao = in.nextInt();

		} while (opcao > 5 || opcao < 1);

		return opcao;
	}

	public static int menuUtilizadores() {
		Scanner in = new Scanner(System.in);
		int opcao;
		System.out.println();
		System.out.println("    Menu de Utilizadores");
		System.out.println();
		System.out.println("1 - Adicionar Utilizador.");
		System.out.println("2 - Apagar Utilizador.");
		System.out.println("3 - Listar todos os Utilizadores.");
		System.out.println("4 - Voltar");
		System.out.println();

		do {

			System.out.println("Opção --> ");
			opcao = in.nextInt();

		} while (opcao > 4 || opcao < 1);

		return opcao;
	}

	public static int menuEmprestimos() {
		Scanner in = new Scanner(System.in);
		int opcao;

		System.out.println();
		System.out.println("    Menu de Empréstimos");
		System.out.println();
		System.out.println("1 - Listar Empréstimos ao utilizador.");
		System.out.println("2 - CheckIn.");
		System.out.println("3 - CheckOut.");
		System.out.println("4 - Listar utilizadores por video.");
		System.out.println("5 - Verificar disponibilidade de um video.");
		
		System.out.println("6 - Voltar");
		System.out.println();

		do {

			System.out.println("Opção --> ");
			opcao = in.nextInt();

		} while (opcao > 6 || opcao < 1);

		return opcao;
	}

}
