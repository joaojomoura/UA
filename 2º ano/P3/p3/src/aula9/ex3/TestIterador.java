/**
 * 
 */
package aula9.ex3;
import java.util.*;
import aula1.ex2.*;
/**
 * @author João Moura
 *
 */
public class TestIterador {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VetorPessoas vp = new VetorPessoas();
		for (int i=0; i<10; i++)
			vp.addPessoa(new Pessoa("Bebe no Vector ",1000+i, new Data(12,12,2020)));
		
		Iterator<Pessoa> vec = vp.iterator();
		while ( vec.hasNext() )
			System.out.println( vec.next() );
		
		ListaPessoas lp = new ListaPessoas();
		for (int i=0; i<10; i++)
			lp.addPessoa(new Pessoa("Bebe na Lista ",2000+i, new Data(12,12,2020)));
		
		Iterator<Pessoa> lista = lp.iterator();
		while ( lista.hasNext() )
			System.out.println( lista.next() );
	}

	

}
