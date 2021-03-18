/**
 * 
 */
package aula1.ex3;

/**
 * @author João Moura
 *
 */
public class Rectangulo {
	private Ponto centro;
	private double largura;
	private double comprimento;
	
	//construtores
	public Rectangulo(double l, double c, Ponto cn)
	{
		this.centro = cn;
		this.largura = l;
		this.comprimento = c;
	}
	
	
	public Rectangulo(double l, double c, double x, double y)
	{
		this.largura = l;
		this.comprimento = c;
		this.centro = new Ponto(x,y);
	}
	
	
	public double largura()
	{
		return largura;
	}
	
	public double comprimento()
	{
		return comprimento;
	}
	
	public Ponto centro()
	{
		return centro;
	}
	
	
	//operaçoes
	
	public double area()
	{
		return largura*comprimento;
	}
	
	public double perimetro()
	{
		return largura*2+comprimento*2;
	}
	
	
	public String toString()
	{
		return "Retângulo com centro em " + centro.toString() + " largura de " + largura + " unidades e comprimento de " + comprimento + " unidades.\n";
	}

}
