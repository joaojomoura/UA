/**
 * 
 */
package aula3.ex2;

/**
 * @author João Moura
 *
 */
public abstract class Figura implements Comparable<Object> {
	
	private Ponto centro;
	
	public Figura (Ponto c) {
		centro = c;
	}
	
	//Metodos abstractos
	public abstract double area();
	public abstract double perimetro();

	public Ponto getCentro() {
		return centro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((centro == null) ? 0 : centro.hashCode());
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
		Figura other = (Figura) obj;
		if (centro == null) {
			if (other.centro != null)
				return false;
		} else if (!centro.equals(other.centro))
			return false;
		return true;
	}
	
	public int compareTo(Object o) {
		Figura f = (Figura) o;
		double difArea = area() - f.area();
		
		if (difArea==0) 
			return 0;
		else if (difArea < 0) 
			return -1;
		else 
			return 1;
	}
	
	
	

}
