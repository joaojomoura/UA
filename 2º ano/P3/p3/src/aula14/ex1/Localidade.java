/**
 * 
 */
package aula14.ex1;

/**
 * @author slowbro
 *
 */
public class Localidade extends Regiao {
	
	//variaveis
	private TipoLocalidade tipo;

	/**
	 * @param nome
	 * @param populacao
	 */
	public Localidade(String nome, int populacao, TipoLocalidade tipo) {
		super(nome, populacao);
		this.tipo=tipo;
	}

	/**
	 * @return the tipo
	 */
	public TipoLocalidade getTipo() {
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
		Localidade other = (Localidade) obj;
		if (tipo != other.tipo)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return " (" + tipo + ": " + super.toString() + ")";
	}
	

}
