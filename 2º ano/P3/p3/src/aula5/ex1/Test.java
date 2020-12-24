/**
 * 
 */
package aula5.ex1;
import aula3.ex2.*;
import aula4.ex2.*;


/**
 * @author João Moura
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Circulo c1 = new Circulo(2);
		Circulo c2 = new Circulo(2, 1, 3); 
		Quadrado q1 = new Quadrado(2);
		Quadrado q2 = new Quadrado(2, 3, 4); 
		Rectangulo r1 = new Rectangulo(2, 3); 
		Rectangulo r2 = new Rectangulo(2, 3, 3, 4);
		
		ColecaoFiguras col = new ColecaoFiguras(42.0); 
		
		System.out.println(col.addFigura(c2)); 
		System.out.println(col.addFigura(r1)); 
		System.out.println(col.addFigura(r1)); 
		System.out.println(col.addFigura(r2)); 
		System.out.println(col.addFigura(c1)); 
		System.out.println(col.addFigura(q2)); 
		System.out.println(col.addFigura(q1)); 
		System.out.println(col.delFigura(r1)); 
		System.out.println(col.addFigura(q1));
		
		System.out.println("\nÁrea Total da Lista de Figuras: " + col.areaTotal());
		Figura[] listaFig = col.getFiguras(); 
		System.out.println("\nLista de Figuras:"); 
		for (Figura f: listaFig)
			System.out.println(f);
		
		System.out.println("\nComparacao da area do primeiro elemento com todos"); 
		for (int i = 0; i < listaFig.length; i++) {
			System.out.printf("%2d %12s de area %6.2f compareTo(listaFig[0]) = %2d\n", i, listaFig[i].getClass().getSimpleName(),
					listaFig[i].area(), listaFig[i].compareTo(listaFig[0]));
		}
		
		System.out.println("\nFigura com maior Area: " + UtilCompare.findMax( listaFig ) );
		
		// Ordena (crescente) o array de Figuras por areas 
		UtilCompare.sortArray(listaFig);
		System.out.println ("\nLista de Figuras Ordenadas por Area:"); 
		for (Figura f: listaFig)
			System.out.println (f + " -> area: " + String.format("%2.2f", f.area()) +
					" e perimetro: " + String.format("%2.2f", f.perimetro()));

	}

}
