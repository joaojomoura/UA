/**
 * 
 */
package aula12.ex3;

import java.util.LinkedList;
import java.util.List;

/**
 * @author João Moura
 *
 */
public class Prato implements Comparable<Prato> {

	private final String nome;
	private final List<Ingrediente> composicao;
	private double totalCalorias = 0;
	
	public Prato(String n) {
		nome = n;
		composicao = new LinkedList<>();
	}
	
	public boolean addIngrediente(Ingrediente e) {
		if(e == null) return false;
		composicao.add(e);
		totalCalorias += e.getCalorias();
		return true;
	}
	
	public boolean removeIngrediente(Ingrediente e) {
		if(e == null) return false;
		if(composicao.contains(e))
			composicao.remove(e);
		else return false;
		return true;
	}
	
	
	public boolean exists(Ingrediente e) {
		return composicao.contains(e);
	}
	
	
	public Ingrediente [] getListIngredients () {
		return composicao.toArray(new Ingrediente[0]);
	}
	
	
	
	public int getNumIngredientes() {
		return composicao.size();
	}
	
	

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}



	/**
	 * @return the composicao
	 */
	public List<Ingrediente> getComposicao() {
		return composicao;
	}




	/**
	 * @return the totalCalorias
	 */
	public double getTotalCalorias() {
		return totalCalorias;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalCalorias);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Prato other = (Prato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(totalCalorias) != Double.doubleToLongBits(other.totalCalorias))
			return false;
		return true;
	}

	@Override
	public int compareTo(Prato p) {
		int dif = (int) (totalCalorias - p.totalCalorias);
		if(dif == 0) return 0;
		else if (dif < 1) return -1;
		else return 1;
	}

	@Override
	public String toString() {
		return "Prato: " + nome + " composto por " + getNumIngredientes() + " Ingredientes";
	}

}
