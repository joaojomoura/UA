/**
 * 
 */
package aula3.ex1;
import aula1.ex2.*;
import static java.lang.System.*;

import java.util.Calendar;


/**
 * @author João Moura
 *
 */
public class E1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Estudante est = new Estudante ("Andreia", 9855678, new Data(18, 7, 1974)); 
		Bolseiro bls = new Bolseiro ("Maria", 8976543, new Data(11, 5, 1976)); 
		bls.setBolsa(745);
		
		out.println("Estudante: " + est.nome());
		out.println(est);
		out.println("Bolseiro: " + bls.nome() + ", NMec: " + bls.getNmec() + ",Bolsa:"+ bls.getBolsa());
		out.println(bls);
		

	}

}
