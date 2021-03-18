/**
 * 
 */
package aula3.ex2;

/**
 * @author João Moura
 *
 */
public class Ponto {
	
	//variaveis
	private double x;
	private double y;
	
	//Construtores 
	public Ponto(double cox, double coy) {
		x = cox;
		y = coy;
	}
	//ponto na origem
	public Ponto() {
		this(0,0);
	}
	
	//getters
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	
	@Override
	public String toString()
	{
		return "(" + x + ", " + y + ")";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ponto other = (Ponto) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}
	
	
	
	
	

}
