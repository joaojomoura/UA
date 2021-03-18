/**
 * 
 */
package aula6.ex1;

/**
 * @author João Moura
 *
 */
public class Carne extends Ingrediente {
	
	private VariedadeCarne variedade;

	/**
	 * @param proteinas
	 * @param calorias
	 * @param peso
	 */
	public Carne(VariedadeCarne v, double proteinas, double calorias, double peso) {
		super(proteinas, calorias, peso);
		variedade = v;
	}

	/**
	 * @return the variedade
	 */
	public VariedadeCarne getVariedade() {
		return variedade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((variedade == null) ? 0 : variedade.hashCode());
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
		Carne other = (Carne) obj;
		if (variedade != other.variedade)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "'Carne: " + variedade + ", " + super.toString();
	}
	

}

enum VariedadeCarne {
	VACA,PORCO,PERU,FRANGO,OUTRA;
}