/**
 * 
 */
package aula6.ex1;

/**
 * @author João Moura
 *
 */
public abstract class Ingrediente implements Comparable<Ingrediente>{
	/**
	 * Atributos
	 */
	private double proteinas;
	private double calorias;
	private double peso;
	
	/**
	 * 
	 * @param proteinas
	 * @param calorias
	 * @param peso
	 */
	public Ingrediente (double proteinas, double calorias, double peso) {
		this.proteinas = proteinas;
		this.peso = peso;
		this.calorias = calorias;
	}
	
	
	/**
	 * @return the proteinas
	 */
	public double getProteinas() {
		return proteinas;
	}
	/**
	 * @return the calorias
	 */
	public double getCalorias() {
		return calorias;
	}
	/**
	 * @return the peso
	 */
	public double getPeso() {
		return peso;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(calorias);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(peso);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(proteinas);
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
		Ingrediente other = (Ingrediente) obj;
		if (Double.doubleToLongBits(calorias) != Double.doubleToLongBits(other.calorias))
			return false;
		if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
			return false;
		if (Double.doubleToLongBits(proteinas) != Double.doubleToLongBits(other.proteinas))
			return false;
		return true;
	}


	@Override
	public int compareTo(Ingrediente a) {
		
		int dif = (int)(calorias - a.calorias);
		if(dif == 0)
			return 0;
		else if(dif < 0)
			return -1;
		else
			return 1;
		
	}


	@Override
	public String toString() {
		return "Proteinas: " + proteinas + ", Calorias: " + calorias + ", Peso: " + peso + "'";
	}
	
	
	
	

}
