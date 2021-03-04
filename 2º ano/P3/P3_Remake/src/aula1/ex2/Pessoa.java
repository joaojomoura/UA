/**
 * 
 */
package aula1.ex2;



/**
 * @author slowbro
 *
 */
public class Pessoa {
	
	private String name;
	private int cc;
	private Data dataNasc;
	
	public Pessoa(String name, int cc, Data dataNasc) throws NumberFormatException, RuntimeException{
		validation(cc, name);
		this.name = name;
		this.cc = cc;
		this.dataNasc = dataNasc;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the cc
	 */
	public int getCc() {
		return cc;
	}

	/**
	 * @return the dataNasc
	 */
	public Data getDataNasc() {
		return dataNasc;
	}
	
	protected void validation(int cc, String name) {
		if(name.matches(".*\\d.*"))
			throw new RuntimeException("Nome nao pode conter numeros");
		if(cc < 0)
			throw new RuntimeException("CC invalido");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cc;
		result = prime * result + ((dataNasc == null) ? 0 : dataNasc.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (cc != other.cc)
			return false;
		if (dataNasc == null) {
			if (other.dataNasc != null)
				return false;
		} else if (!dataNasc.equals(other.dataNasc))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Nome: " + name + "\nCC: " + cc + "\nData de nascimento: " + dataNasc.toString();
	}
	
	
	

}
