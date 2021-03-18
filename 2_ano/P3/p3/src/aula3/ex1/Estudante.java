/**
 * 
 */
package aula3.ex1;
import aula1.ex2.*;
import java.util.*;

/**
 * @author João Moura
 *
 */
public class Estudante extends Pessoa {
	
	/**
	 * Variaveis
	 */
	private int nmec;
	private Data inscricao;
	private static int inicio = 100;
	protected static Calendar calendar = Calendar.getInstance(); 
	
	
	/**
	 * @constructor Estudante
	 * @param inome
	 * @param iBI
	 * @param iDataNasc
	 * @param iDataInsc
	 */
	public Estudante (String inome, int iBI, Data iDataNasc, Data iDataInsc){
		super(inome,iBI,iDataNasc);
		nmec = inicio++;
		inscricao = iDataInsc;
	}
	
	/**
	 * @constructor Estudante
	 * @param iNome
	 * @param iBI
	 * @param iDataNasc
	 */
	public Estudante(String iNome, int iBI, Data iDataNasc) {
		this(iNome,iBI,iDataNasc,new Data(calendar.get(Calendar.DAY_OF_MONTH),
				calendar.get(Calendar.MONTH),calendar.get(Calendar.YEAR)));
	}

	/**
	 * 
	 * @return numero mec
	 */
	public int getNmec() {
		return nmec;
	}

	/**
	 * 
	 * @return data de inscriçao
	 */
	public Data getInscricao() {
		return inscricao;
	}
	
	@Override
	public String toString() {
		return super.nome() + ", BI: " + super.cc() + ", Nasc.Data: " + super.dataNasc() + 
				", NMec: " + nmec + ", inscrito em Data: " + inscricao;
	}

}
