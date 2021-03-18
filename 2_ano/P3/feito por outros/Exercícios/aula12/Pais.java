package aula12;

public class Pais {
	private String nome;
	private Localidade capital;
	private MyList<Regiao> regioes;
	
	public Pais(String nome, Localidade capital, MyList<Regiao> regioes) {
		this.nome = nome;
		this.capital = capital;
		this.regioes = regioes;
	}

	public String getNome() {
		return nome;
	}

	public Localidade getCapital() {
		return capital;
	}

	public MyList<Regiao> getRegioes() {
		return regioes;
	}

	@Override
	public String toString() {
		System.out.println("Pais: " + nome + ", capital: " + capital + ", regioes: ");
		return regioes.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		if (capital == null) {
			if (other.capital != null)
				return false;
		} else if (!capital.equals(other.capital))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
