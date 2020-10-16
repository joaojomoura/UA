package aula12;

public class Estado extends Regiao {
	private Localidade capital;
	
	public Estado(String nome, int populacao, Localidade capital)
		throws IllegalArgumentException{
		super(nome, populacao);
		
		if (capital.getTipo() == TipoLocalidade.CIDADE) {
			this.capital = capital;
		}
		else {
			throw new IllegalArgumentException("A capital tem de ser uma cidade!");
		}
	}

	public Localidade getCapital() {
		return capital;
	}

	@Override
	public String toString() {
		return super.toString()+", capital: "+capital;
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
}
