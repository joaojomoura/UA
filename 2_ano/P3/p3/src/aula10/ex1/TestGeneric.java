/**
 * 
 */
package aula10.ex1;
import aula3.ex2.*;
import aula1.ex2.*;
import java.util.*;

/**
 * @author João Moura
 *
 */
public class TestGeneric {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VetorGeneric<Pessoa> vp = new VetorGeneric<Pessoa>();
		for (int i=0; i<10; i++)
			vp.addElem(new Pessoa("Bebé no Vector ",
					1000+i, new Data(12,12,2020))); //para não estar a alterar a classe pessoa e data, fiz esta pequena alteraçao
		
		Iterator<Pessoa> vec = vp.iterator();
		printSet(vp.iterator());
		
		ListGeneric<Pessoa> lp = new ListGeneric<Pessoa>();
		while ( vec.hasNext() )
			lp.addElem( vec.next() );
		
		Iterator<Pessoa> lista = lp.iterator();
		while ( lista.hasNext() )
			System.out.println( lista.next() );
		
		ListGeneric<Figura> figList = new ListGeneric<Figura>();
		figList.addElem(new Circulo (1,3, 1));
		figList.addElem(new Quadrado(3,4, 2));		
		figList.addElem(new Rectangulo(1,2, 2,5));
		
		printSet(figList.iterator());
		
		System.out.println("Soma da Area de Lista de Figuras: " + sumArea(figList));

		// Partindo do principio que Quadrado extends Rectangulo:
		ListGeneric<Rectangulo> quadList = new ListGeneric<Rectangulo>();
		quadList.addElem(new Quadrado(3,4, 2));
		quadList.addElem(new Rectangulo(1,2, 2,5));
		System.out.println("Soma da Area de Lista de Quadrados: " +
		sumArea(quadList));


	}
	
	public static double sumArea(ListGeneric<? extends Figura> list)
	{
		double sum = 0;
		for (Figura fig : list)
		{
			sum += fig.area();
			System.out.println(fig);
		}
		
		return sum;
	}
	
	public static <T> void printSet(Iterator<T> iter)
	{
		while(iter.hasNext())
			System.out.println(iter.next());
	}

}
