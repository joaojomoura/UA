/**
 * 
 */
package aula1.ex3;

/**
 * @author João Moura
 *
 */
public class Quadrado {
	private Ponto centro;
	private double lado;
	
	//Construtores
	public Quadrado(double l, Ponto c)
	{
		this.lado = l;
		this.centro = c;
	}
	
	
	public Quadrado(double l, double x, double y)
	{
		this.lado = l;
		this.centro = new Ponto(x,y);
	}
	
	public Ponto centro()
	{
		return centro;
	}
	
	public double lado()
	{
		return lado;
	}
	
	/**
	 * 
	 * operaçoes!!!
	 */
	
	public double area()
	{
		return lado*lado;
	}
	
	
	
	public double perimetro()
	{
		return lado*4;
	}
	
	
	public String toString()
	{
		return "Quadrado com centro em " + centro.toString() + " e lateral de " + lado + "unidades\n";
	}

}
