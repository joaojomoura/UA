/**
 * 
 */
package aula4.ex2;
import aula3.ex2.*;

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
		 Rectangulo r1 = new Rectangulo(3, 2);
		 Rectangulo r2 = new Rectangulo(3, 2, 3, 4);
		 ColecaoFiguras col = new ColecaoFiguras(42.0); // MaxArea
		 
		 System.out.println(col.addFigura(c2)); // true
		 System.out.println(col.addFigura(r1)); // true
		 System.out.println(col.addFigura(r1)); // false
		 System.out.println(col.addFigura(r2)); // true
		 System.out.println(col.addFigura(c1)); // true
		 System.out.println(col.addFigura(q2)); // true
		 System.out.println(col.addFigura(q1)); // false
		 System.out.println(col.delFigura(r1)); // true
		 System.out.println(col.addFigura(q1)); // true

		 System.out.println("\nÁrea Total da Lista de Figuras: " + col.areaTotal());

		 System.out.println("\nLista de Figuras:");
		 
		 for (Figura f: col.getFiguras())
		 System.out.println(f);

		 System.out.println("\n\nCirculos na Lista de Figuras:");
		 
		 for (Figura f: col.getFiguras())
		 if (f instanceof Circulo)
		 System.out.println(f);

		 System.out.println("\n\nCentro das Figuras:");
		 
		 for (Ponto p: col.getCentros())
		 System.out.println(p);

	}

}
