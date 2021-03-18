/**
 * 
 */
package aula14.ex1;

/**
 * @author slowbro
 *
 */
public class Regiao {
	//variaveis
	
	private String nome;
	private int populacao;
	
	//Construtor
	public Regiao(String nome, int populacao){
		if(populacao < 0)
			throw new IllegalArgumentException();
		this.nome = nome;
		this.populacao = populacao;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}



	/**
	 * @return the populacao
	 */
	public int getPopulacao() {
		return populacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + populacao;
		return result;
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

	@Override
	public String toString() {
		return nome + ", populacao " + populacao; 
	}

	
	

}
