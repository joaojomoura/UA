/**
 * 
 */
package aula1.ex2;

/**
 * @author João Moura
 *
 */
public class Pessoa {
	private String nome;
	private int cc;
	private Data dataNasc;
	/**
	 * 
	 */
	
	/**
	 * Construtor pessoa
	 * @param nome
	 * @param cc
	 * @param dataNasc
	 */
	public Pessoa(String nome, int cc, Data dataNasc) {
		// TODO Auto-generated constructor stub
		valido(nome,cc);
		this.nome = nome;
		this.cc = cc;
		this.dataNasc = dataNasc;
	}
	
	
	public String nome() {
		return nome;
	}
	
	
	public int cc() {
		return cc;
	}
	
	
	public Data dataNasc() {
		return dataNasc;
	}
	
	/**
	 * 
	 * @param nome
	 * @param cc
	 * @return validaçao do nome e cc
	 */
	private void valido(String nome, int cc) {
		if(cc < 0)
			throw new RuntimeException("CC Invalido");
		if(nome.matches(".*\\d.*"))
			throw new RuntimeException("Nome Invalido");
	}
	
	public String toString() 
	{
		return "cc=" + cc + ", nome=" + nome + ", dataNasc=" + dataNasc;
	}
}
