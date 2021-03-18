/**
 * 
 */
package aula5.ex3;

import aula1.ex2.Data;
import aula1.ex2.Pessoa;

/**
 * @author João Moura
 *
 */
public class Contato extends Pessoa {

	/**
	 * @param nome
	 * @param cc
	 * @param dataNasc
	 */
	public Contato(String nome, int cc, Data dataNasc) {
		super(nome, cc, dataNasc);
		// TODO Auto-generated constructor stub
	}
	
	public int getNum() {
		return cc();
	}

	@Override
	public String toString() {
		return "Contato -> " + nome() + ", nº de telemovel: " + cc()
		+ " Data de nascimento: " + dataNasc();
	}
	
	

}
