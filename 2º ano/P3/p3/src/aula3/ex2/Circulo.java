/**
 * 
 */
package aula3.ex2;

/**
 * @author João Moura
 *
 */
public class Circulo extends Figura{
	
	//atributos
	private double raio;
	
	
	//Construtores
	public Circulo(double r, Ponto centro) {
		super(centro);
		raio = r;
	}
	
	public Circulo(double r) {
		this(r, new Ponto());
	}
	
	public Circulo(double r, double x,double y) {
		this(r,new Ponto(x,y));
	}
	
	public Circulo(Circulo c) {
		this(c.raio,c.getCentro());
	}
	
	public double getRaio() {
		return raio;
	}
	
	
	//metodos
	
	@Override
	public String toString()
	{
		return "Circulo de raio: " + raio + " e centro: " + this.getCentro();
	}
	
	@Override
	public double area()
	{
		return Math.PI * Math.pow(raio, 2);
	}
	
	@Override
	public double perimetro()
	{
		return 2 * Math.PI * raio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(raio);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circulo other = (Circulo) obj;
		if (Double.doubleToLongBits(raio) != Double.doubleToLongBits(other.raio))
			return false;
		return true;
	}

	
	
	
	

}
