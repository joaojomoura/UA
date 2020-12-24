/**
 * 
 */
package aula5.ex2;

import java.util.InputMismatchException;

/**
 * @author João Moura
 *
 */
public abstract class Veiculo implements Comparable <Object>{
	
	/**
	 * Atributos
	 */
	private int ano;
	private String marca;
	private String cor;
	private int nrodas;
	
	
	/**
	 * Construtor
	 * @param mark
	 * @param year
	 * @param n
	 * @param colour
	 */
	public Veiculo (String mark, int year, int n, String colour) {
		//Verifica se é de duas rodas ou 4 rodas
		if(n != 2 && n != 4)
			throw new InputMismatchException();
		
		marca = mark;
		ano = year;
		nrodas = n;
		cor = colour;
	}

	/**
	 * @return the ano
	 */
	public int getAno() {
		return ano;
	}

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @return the cor
	 */
	public String getCor() {
		return cor;
	}

	/**
	 * @return the nrodas
	 */
	public int getNrodas() {
		return nrodas;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ano;
		result = prime * result + ((cor == null) ? 0 : cor.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + nrodas;
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
		Veiculo other = (Veiculo) obj;
		if (ano != other.ano)
			return false;
		if (cor == null) {
			if (other.cor != null)
				return false;
		} else if (!cor.equals(other.cor))
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (nrodas != other.nrodas)
			return false;
		return true;
	}

	public abstract String toString();
	
	public int compareTo(Object o) {
		Veiculo v = (Veiculo) o;
		
		int difAno = getAno() - v.getAno();
		
		if(difAno == 0)
			return 0;
		else if(difAno < 0)
			return -1;
		else
			return 1;
	}
	

}
