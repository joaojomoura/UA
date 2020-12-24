/**
 * 
 */
package aula2.ex1;
import java.util.*;
import java.time.Year;
import static java.lang.System.*;
/**
 * @author João Moura
 *
 */
public class Emprestimos {
	private Hashtable<String, Emprestimo> emprestimos;
	  
	  public Emprestimos()
	  {
		  emprestimos = new Hashtable<String, Emprestimo>();
	  }
	  
	  public boolean newLoanAluno(Data ot, Aluno s, Movie m)
	  {
		  int idade = (Year.now().getValue()) - (s.getNascimento()).getAno();
		  int month = Calendar.getInstance().get(Calendar.MONTH) + 1 - (s.getNascimento()).getMes();
		  int d = Calendar.getInstance().get(Calendar.DAY_OF_MONTH) - (s.getNascimento()).getDia();
		  if (month < 0 || d < 0)
		  {
			  idade--;
		  }
		  
		  if(!m.getExiste() || 
				  (m.getIdade().equals("M18") && idade < 18) || 
				  (m.getIdade().equals("M16") && idade < 16) || 
				  (m.getIdade().equals("M12") && idade < 12) || 
				  (m.getIdade().equals("M6") && idade < 6))
		  {
			  out.println("Não pode retirar o filme");
			  return false;
		  }
		  else
		  {
			  emprestimos.put(s.getnSocio() + "-" + m.getID(), new Emprestimo(ot, s.getnSocio(), m));
			  return m.out();
		  }
	  }
	  
	  public boolean newLoanFunc(Data ot, Funcionario s, Movie m)
	  {
		  int idade = (Year.now().getValue()) - (s.getNascimento()).getAno();
		  int month = Calendar.getInstance().get(Calendar.MONTH) + 1 - (s.getNascimento()).getMes();
		  int d = Calendar.getInstance().get(Calendar.DAY_OF_MONTH) - (s.getNascimento()).getDia();
		  if (month < 0 || d < 0)
		  {
			  idade--;
		  }
		  
		  if(!m.getExiste() || 
				  (m.getIdade().equals("M18") && idade < 18) || 
				  (m.getIdade().equals("M16") && idade < 16) || 
				  (m.getIdade().equals("M12") && idade < 12) || 
				  (m.getIdade().equals("M6") && idade < 6))
		  {
			  out.println("Não pode retirar o filme");
			  return false;
		  }
		  else
		  {
			  emprestimos.put(s.getnSocio() + "-" + m.getID(), new Emprestimo(ot, s.getnSocio(), m));
			  return m.out();
		  }
	  }
	  
	  public void returnMovieFunc(Data in, Funcionario s, Movie m, int r)
	  {
		  Emprestimo tmp;
		  try
		  {
			  tmp = emprestimos.get(s.getnSocio() + "-" + m.getID());
			  tmp.deposit(in);
			  m.updateRating(r);
			  emprestimos.replace(s.getnSocio() + "-" + m.getID(), tmp);
		  }
		  catch (NullPointerException e)
		  {
			  out.printf("Não existe nenhum empréstimo do filme ao sócio.\n");
		  }
	  }
	  
	  public void returnMovieAluno(Data in, Aluno s, Movie m, int r)
	  {
		  Emprestimo tmp;
		  try
		  {
			  tmp= emprestimos.get(s.getnSocio() + "-" + m.getID());
			  tmp.deposit(in);
			  m.updateRating(r);
			  emprestimos.replace(s.getnSocio() + "-" + m.getID(), tmp);
		  }
		  catch(NullPointerException e)
		  {
			  out.printf("Não existe nenhum empréstimo do filme ao sócio.\n");
		  }
	  }
	  
	  public int[] getMovieHistory(int socios, int movieID, ArrayList<Integer> jumps)
	  {
		  int users[] = new int[socios+1+jumps.size()];
		  int tmp = 0;
		  for(int i = 1; i < users.length; i++)
		  {
			  if(emprestimos.containsKey(i + "-" + movieID))
			  {
				 users[tmp++] = i;
			  }
		  }
		  int onlyUsed[] = new int[tmp];
		  arraycopy(users, 0, onlyUsed, 0, tmp);
		  return onlyUsed;
	  }
	  
	  public void remEmprestimosOfSoc(int socio, int movies)
	  {
		  for(int i = 1; i <= movies; i++)
		  {
			  if (emprestimos.containsKey(socio + "-" + i))
			  {
				  emprestimos.remove(socio + "-" + i);
			  }
		  }
	  }

	  public void remEmprestimosOfMov(int movie, int socios)
	  {
		  for(int i = 1; i <= socios; i++)
		  {
			  if (emprestimos.containsKey(i + "-" + movie))
			  {
				  emprestimos.remove(i + "-" + movie);
			  }
		  }
	  }
	  
	  public int[] getSocHistory(int soc, int movies)
	  {
		  int all[] = new int[movies+1];
		  int tmp = 0;
		  for(int i = 1; i < all.length; i++)
		  {
			  if(emprestimos.containsKey(soc + "-" + i))
			  {
				  all[tmp++] = i;
			  }
		  }
		  int onlyUsed[] = new int[tmp];
		  arraycopy(all, 0, onlyUsed, 0, tmp);
		  return onlyUsed;
	  }

}
