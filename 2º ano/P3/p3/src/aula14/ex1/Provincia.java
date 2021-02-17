/**
 * 
 */
package aula14.ex1;

/**
 * @author slowbro
 *
 */
public class Provincia extends Regiao {
	
	//variaveis
	private String governador;

	/**
	 * @param nome
	 * @param populacao
	 */
	public Provincia(String nome, int populacao,String governador) {
		super(nome, populacao);
		this.governador = governador;
	}

	/**
	 * @return the governador
	 */
	public String getGovernador() {
		return governador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((governador == null) ? 0 : governador.hashCode());
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
		Provincia other = (Provincia) obj;
		if (governador == null) {
			if (other.governador != null)
				return false;
		} else if (!governador.equals(other.governador))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Provincia: " + super.toString() + " -> Governador: " + governador + "\n";
	}
	
	

}
