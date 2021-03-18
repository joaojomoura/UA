package aula14.ex1;

import java.util.*;

import java.util.stream.Collectors;

public class Pais  {
	
	//variaveis
	private String nome;
	private int populacao;
	private Localidade capital;
	private Set<Regiao> regioes;

	//Construtores
	public Pais(String nome, Localidade capital) {
		this.nome = nome;
		populacao = 0;
		this.capital = capital;
		this.regioes = new HashSet<>();
		
	}
	
	public Pais(String nome) {
		this(nome,new Localidade("*Indefinida*",0,null));
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

	/**
	 * @return the capital
	 */
	public Localidade getCapital() {
		return capital;
	}

	/**
	 * @return the regioes
	 */
	public Regiao[] getRegioes() {
		return regioes.toArray(new Regiao[regioes.size()]);
	}
	
	//metodos
	public void addRegiao(Regiao r) {
		if(regioes.add(r))
			populacao += r.getPopulacao();
	}
	
	public void removeRegiao(Regiao r) {
		if(regioes.remove(r))
			populacao -= r.getPopulacao();
	}
	
	public void sort(Comparator<Regiao> c) {
		List<Regiao> listaReg = regioes.stream().collect(Collectors.toList());
		Collections.sort(listaReg, c);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capital == null) ? 0 : capital.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + populacao;
		result = prime * result + ((regioes == null) ? 0 : regioes.hashCode());
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
		if (populacao != other.populacao)
			return false;
		if (regioes == null) {
			if (other.regioes != null)
				return false;
		} else if (!regioes.equals(other.regioes))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		if(capital.getTipo() == null)
			return "Pais: " + nome + ", Populacao: " + populacao + " (Capital: " + capital.getNome() + ")";
		return "Pais: " + nome + ", Populacao: " + populacao + " (Capital: " + capital + ")";
	}
	
	
	

}
