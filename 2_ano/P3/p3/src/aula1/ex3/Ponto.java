/**
 * 
 */
package aula1.ex3;

/**
 * @author Joao Moura
 *
 */
public class Ponto {
	private double x;
	private double y;
	
	/**
	 * 
	 * Construtor ponto
	 * @param a
	 * @param b
	 */
	public Ponto(double a, double b)
	{
		x = a;
		y = b;
	}

	public double coordenadaX() 
	{
		return x;
	}

	public double coordenadaY() 
	{
		return y;
	}

	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	/**
	 * Calculo da distancia
	 * @param p
	 * @return a distancia entre 2 pontos
	 */
	public double distancia(Ponto p)
	{
		return Math.sqrt(Math.pow(this.x-p.x, 2) + Math.pow(this.y - p.y, 2));
	}

}
