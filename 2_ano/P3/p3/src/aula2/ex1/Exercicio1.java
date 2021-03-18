/**
 * 
 */
package aula2.ex1;
import java.util.*;
import static java.lang.System.*;
/**
 * @author João Moura
 *
 */
public class Exercicio1 {
	final static Scanner k = new Scanner(in); 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VideoClube v = new VideoClube(6);
		  int option = -1;
		  do {
			  try
			  {
				  menu();
				  option = k.nextInt();
				  switch(option) {
					  case 0:
						  out.println("Adeus.\n");
						  break;
					  case 1:
						  v.addsoc();
						  break;
					  case 2:
						  v.remsoc();
						  break;
					  case 3:
						  v.searchMov();
						  break;
					  case 4:
						  v.listVid();
						  break;
					  case 5:
						  v.putVid();
						  break;
					  case 6:
						  v.remVid();
						  break;
					  case 7:
						  v.canVid();
						  break;
					  case 8:
						  v.loanVid();
						  break;
					  case 9:
						  v.retVideo();
						  break;
					  case 10:
						  v.checkReq();
						  break;
					  case 11:
						  v.showAll();
						  break;
					  case 12:
						  v.showRated();
						  break;
					  case 13:
						  v.checkSocHist();
						  break;
					  case 14:
						  v.print();
						  break;
					  default:
						  out.println("Não é uma opção");
						  break;
				  }
			  }
			  catch (InputMismatchException e)
			  {
				  out.print("Erro na última entrada.\n");
				  k.nextLine();
			  }
			  catch (NumberFormatException e)
			  {
				  out.print("Colocadasletras onde se esperavam números na última entrada.\n");
				  k.nextLine();
			  }
			  catch (ArrayIndexOutOfBoundsException e)
			  {
				  out.println("Erro no acesso pretendido.\n");
			  }
			  catch (RuntimeException e)
			  {
				  out.println("Erro ao colocar uma data.\n");
				  k.nextLine();
			  }
			  
		  } while(option != 0);
	  }
	  
	  public static void menu()
	  {
	    out.printf("|-------------------------------------------------------------------|\n");
	    out.printf("|                                Menu                               |\n");
	    out.printf("|-------------------------------------------------------------------|\n");
	    out.printf("|   1  -> Introduzir novo Sócio                                     |\n");
	    out.printf("|   2  -> Remover sócio por número de sócio                         |\n");
	    out.printf("|   3  -> Pesquisar vídeo pelo Id                                   |\n");
	    out.printf("|   4  -> Listar todos os vídeos acessíveis ao utilizador           |\n");
	    out.printf("|   5  -> Introduzir novo vídeo                                     |\n");
	    out.printf("|   6  -> Remover vídeo pelo Id                                     |\n");
	    out.printf("|   7  -> Verificar se o vídeo pretendido está disponível           |\n");
	    out.printf("|   8  -> Efetuar empréstimo de um vídeo                            |\n");
	    out.printf("|   9  -> Devolver um vídeo                                         |\n");
	    out.printf("|  10  -> Ver quem requesitou um vídeo                              |\n");
	    out.printf("|  11  -> Ver catálogo de Filmes                                    |\n");
	    out.printf("|  12  -> Ver catálogo de Filmes por Rating                         |\n");
	    out.printf("|  13  -> Ver os filmes repositados por um Sócio                    |\n");
	    out.printf("|  14  -> Lista de Socios                                           |\n");
	    out.printf("|   0  -> Sair do programa                                          |\n");
	    out.printf("|-------------------------------------------------------------------|\n");
	    out.printf("\nOpção: ");
	  }
	

}
