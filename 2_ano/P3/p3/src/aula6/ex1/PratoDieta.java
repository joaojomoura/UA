/**
 * 
 */
package aula6.ex1;

/**
 * @author João Moura
 *
 */
public class PratoDieta extends Prato {
	private final double maxCalorias;
	/**
	 * @param n
	 */
	public PratoDieta(String n, double m) {
		super(n);
		maxCalorias = m;
	}
	
	
	
	
	
	/**
	 * @return the maxCalorias
	 */
	public double getMaxCalorias() {
		return maxCalorias;
	}





	@Override
	public boolean addIngrediente(Ingrediente e) {
		if(e == null) return false;
		if(e.getCalorias() + super.getTotalCalorias() <= maxCalorias)
			return super.addIngrediente(e);
		return false;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(maxCalorias);
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
		PratoDieta other = (PratoDieta) obj;
		if (Double.doubleToLongBits(maxCalorias) != Double.doubleToLongBits(other.maxCalorias))
			return false;
		return true;
	}
	
	
	

}
