/**
 * 
 */
package aula12.ex3;

/**
 * @author João Moura
 *
 */
public class Peixe extends Ingrediente {
	
	private Tipo tipo;

	/**
	 * @param proteinas
	 * @param calorias
	 * @param peso
	 */
	public Peixe(Tipo t, double proteinas, double calorias, double peso) {
		super(proteinas, calorias, peso);
		tipo = t;
	}

	/**
	 * @return the tipo
	 */
	public Tipo getTipo() {
		return tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Peixe other = (Peixe) obj;
		if (tipo != other.tipo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "'Peixe: " + tipo + ", " + super.toString();
	}
	

}

enum Tipo{
	CONGELADO,FRESCO;
}
