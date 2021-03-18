package aula06;

public class Legume extends Alimento {
	
	private String nome;

	public Legume(String nome, double proteinas, double calorias, double peso) {
		super(proteinas, calorias, peso);
		this.nome = nome;
	}

	public String toString() {
		return "Legume -> "+nome+", "+super.toString();
	}
	
	public String whoAmI() {
		return "Legume";
	}
	
	public String getNome() {
		return nome;
	}
	
	public boolean equals(Object obj) {
		if (obj==null || (getClass() != obj.getClass()) ) {
			return false;
		}
		if (obj==this) {
			return true;
		}
		
		Legume le = (Legume) obj;
		return (this.nome == le.getNome() && super.equals(le));
	}
}
