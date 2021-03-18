package aula12;

public class Regiao {
	private String nome;
	private int populacao;
	
	public Regiao(String nome, int populacao) {
		this.nome = nome;
		this.populacao = populacao;
	}

	public String getNome() {
		return nome;
	}

	public int getPopulacao() {
		return populacao;
	}

	@Override
	public String toString() {
		return "Regiao: " + nome + ", populacao: " + populacao;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Regiao other = (Regiao) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (populacao != other.populacao)
			return false;
		return true;
	}	
}
