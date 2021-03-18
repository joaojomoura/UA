package aula12;

public class Provincia extends Regiao {
	private String governador;

	public Provincia(String nome, int populacao, String governador) {
		super(nome, populacao);
		this.governador = governador;
	}

	public String getGovernador() {
		return governador;
	}

	@Override
	public String toString() {
		return super.toString()+", governador: " + governador;
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
}
