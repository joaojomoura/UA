/**
 * 
 */
package aula14.ex1;

/**
 * @author slowbro
 *
 */
public class Estado extends Regiao {

	private Localidade capital;
	/**
	 * @param nome
	 * @param populacao
	 */
	public Estado(String nome, int populacao,Localidade capital) {
		super(nome, populacao);
		if(capital != null)
			if(!capital.getTipo().equals(TipoLocalidade.CIDADE))
				throw new IllegalArgumentException();
		this.capital = capital;
	}
	/**
	 * @return the capital
	 */
	public Localidade getCapital() {
		return capital;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((capital == null) ? 0 : capital.hashCode());
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
		Estado other = (Estado) obj;
		if (capital == null) {
			if (other.capital != null)
				return false;
		} else if (!capital.equals(other.capital))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Estado: " + super.toString() + "Capital: " + capital.toString();
	}

}