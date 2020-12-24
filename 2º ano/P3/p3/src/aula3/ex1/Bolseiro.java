/**
 * 
 */
package aula3.ex1;
import java.util.Calendar;

import aula1.ex2.*;

/**
 * @author João Moura
 *
 */
public class Bolseiro extends Estudante{
	
	//variaveis
	private int bolsa;
	
	//Construtores
	public Bolseiro (String iNome, int iBI, Data iDataNasc, Data iDataInsc) {
		super(iNome,iBI,iDataNasc,iDataInsc);
		bolsa = 0;
	}
	
	public Bolseiro (String iNome, int iBI, Data iDataNasc) {
		this(iNome,iBI,iDataNasc,new Data(calendar.get(Calendar.DAY_OF_MONTH),
				calendar.get(Calendar.MONTH),calendar.get(Calendar.YEAR)));
	}

	//getter and setter
	public int getBolsa() {
		return bolsa;
	}

	public void setBolsa(int b) {
		bolsa = b;
	}
	
	@Override
	public String toString() {
		return super.nome() + ", BI: " + super.cc() + ", Nasc. Data: " + super.dataNasc() +
				", NMec: " + super.getNmec() + ", inscrito em Data: " + super.getInscricao() + ", Bolseiro com bolsa: " + bolsa;
	}

}
