/**
 * 
 */
package aula2.ex1;

/**
 * @author Joao Moura
 *
 */
public class Emprestimo {
		//variaveis
	  private Data checkOut;
	  private Data checkIn;
	  private int loaned;
	  private Movie picked;
	  
	  
	  //construtor
	  public Emprestimo(Data out, int loan, Movie p)
	  {
		  checkOut = out;
		  loaned = loan;
		  picked = p;
	  }

	  
	 
	  //getters
	  public Data getCheckOut() 
	  {
		return checkOut;
	  }
		
	  public Data getCheckIn() 
	  {
		  return checkIn;
	  }
		
	  public int getLoaned() 
	  {
		  return loaned;
	  }
		
	  public Movie getPicked() 
	  {
		  return picked;
	  }
	  
	  //deposito
	  public void deposit(Data in)
	  {
		  checkIn = in;
		  picked.in();
	  }
	  @Override
	  public String toString() 
	  {
		  if (checkIn == null)
			  return "Loan [checkOut=" + checkOut.toString() + ", loaned=" + loaned + ", picked=" + picked.getTitulo() + "]";
		  else
			  return "Loan [checkOut=" + checkOut.toString() + ", loaned=" + loaned + ", picked=" + picked.getTitulo() + ", checkIn=" + checkIn.toString() + "]";
	  }
}
