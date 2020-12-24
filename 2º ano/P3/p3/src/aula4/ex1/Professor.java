/**
 * 
 */
package aula4.ex1;
import java.util.Calendar;

import aula1.ex2.*;


/**
 * @author João Moura
 *
 */
public class Professor extends Pessoa{
	
	//Atributos
	private Data dataAdmissao;
	private int nfun;
	private static int funcionarios = 0;
	protected static Calendar calendar = Calendar.getInstance(); 
	
	//Construtores
	protected Professor (String nome, int cc, Data nasc, Data dA) {
		super(nome,cc,nasc);
		dataAdmissao = dA;
		nfun = ++funcionarios;
	}
	
	protected Professor (String nome, int cc, Data nasc) {
		this(nome,cc,nasc,new Data(calendar.get(Calendar.DAY_OF_MONTH),
				calendar.get(Calendar.MONTH),calendar.get(Calendar.YEAR)));
	}

	
	//getters
	public Data getDataAdmissao() {
		return dataAdmissao;
	}

	public int getNfun() {
		return nfun;
	}
	
	/**
	 * @return the funcionarios
	 */
	public static int getFuncionarios() {
		return funcionarios;
	}

	
	@Override
	public String toString()
	{
		return "PROFESSOR: " + super.nome() + ", BI: " + super.cc() + ", Nascido na Data: " + super.dataNasc() + 
				", NMec: " + nfun + ", Admitido em Data: " + dataAdmissao;
	}

}
