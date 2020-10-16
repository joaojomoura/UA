package aula06;

public class Cereal extends Alimento {
	
	private String nome;

	public Cereal(String nome, double proteinas, double calorias, double peso) {
		super(proteinas, calorias, peso);
		this.nome = nome;
	}
	
	public String toString() {
		return "Cereal -> "+nome+", "+super.toString();
	}
	
	public String whoAmI() {
		return "Cereal";
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
		
		Cereal ce = (Cereal) obj;
		return (this.nome == ce.getNome() && super.equals(ce));
	}
}
