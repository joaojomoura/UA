/**
 * 
 */
package aula1.ex3;

/**
 * @author João Moura
 *
 */
public class Circulo {
	private Ponto centro;
	private double raio;
	
	//Construtores
	public Ponto centro() {
		return centro;
	}
	
	public double r() {
		return raio;
	}
	
	public Circulo (double x, double y, double r) {
		this.centro = new Ponto(x,y);
		this.raio = r;
	}
	
	public Circulo(Ponto centro, double r)
	{
		this.raio = r;
		this.centro = centro;
	}
	
	
	//Operaçoes
	public double area()
	{
		return Math.PI * raio * raio;
	}
	
	public double perimetro()
	{
		return Math.PI * 2 * raio;
	}
	
	
	
	public String toString()
	{
		return "Circulo com centro em " + centro.toString() + " e raio de " + raio + " unidades.\n"; 
	}
	
	public boolean equals(Circulo comparar)
	{
		return (this.raio == comparar.raio);
	}
	
	public boolean interception(Circulo c)
	{
		return (centro.distancia(c.centro()) <= raio);
	}


}
