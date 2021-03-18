package aula06;

public class Carne extends Alimento {

	private VariedadeCarne variedade;

	public Carne(VariedadeCarne variedade, double proteinas, double calorias, double peso) {
		super(proteinas, calorias, peso);
		this.variedade = variedade;
	}
	
	public VariedadeCarne getVariedade() {
		return variedade;
	}

	public String toString () {
		return "Carne -> "+variedade+", "+super.toString();
	}
	
	public String whoAmI() {
		return "Carne";
	}
	
	public boolean equals(Object obj) {
		if (obj==null || (getClass() != obj.getClass()) ) {
			return false;
		}
		if (obj==this) {
			return true;
		}
		
		Carne c = (Carne) obj;
		return (this.variedade == c.getVariedade() && super.equals(c));
	}
}
