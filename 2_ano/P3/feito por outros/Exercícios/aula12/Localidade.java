package aula12;

public class Localidade {
	private String nome;
	private int populacao;
	private TipoLocalidade tipo;
	
	public Localidade(String nome, int populacao, TipoLocalidade tipo) {
		this.nome = nome;
		this.populacao = populacao;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public int getPopulacao() {
		return populacao;
	}

	public TipoLocalidade getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return nome + ", populacao: " + populacao
				+ ", tipo: " + tipo;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Localidade other = (Localidade) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (populacao != other.populacao)
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}	
}
