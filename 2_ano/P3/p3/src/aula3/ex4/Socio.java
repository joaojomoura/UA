/**
 * 
 */
package aula3.ex4;



/**
 * @author João Moura
 *
 */
public class Socio {
	
	//variaveis
	private static int seqSoc = 1;
	private final int nSocio;
	private final String nome;
	private final int nCC;
	private final Data  inscricao;
	private final Data nascimento;
	private final int maxLoans;
	private int loans;
	
	
	//Construtor
	public Socio(String n, int cc, Data ins, Data nas,int l) {
		nSocio = seqSoc++;
		nome = n;
		nCC = cc;
		inscricao = ins;
		nascimento = nas;
		maxLoans = l;
		this.loans = 0; 
		
	}

	
	//getters
	public int getnSocio() {
		return nSocio;
	}

	public String getNome() {
		return nome;
	}

	public int getnCC() {
		return nCC;
	}

	public Data getInscricao() {
		return inscricao;
	}

	public Data getNascimento() {
		return nascimento;
	}
	
	public boolean newLoan()
	{
		if (loans < maxLoans)
		{
			loans++;
			return true;
		}	
		return false;
	}
	
	public int loanAmount()
	{
		return loans;
	}
	
	public void clearLoan()
	{
		loans--;
	}
	
	

}
