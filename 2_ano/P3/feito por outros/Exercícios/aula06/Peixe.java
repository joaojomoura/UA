package aula06;

public class Peixe extends Alimento {

	private TipoPeixe tipo;
	
	public Peixe(TipoPeixe tipo, double proteinas, double calorias, double peso) {
		super(proteinas, calorias, peso);
		this.tipo = tipo;
	}
	
	public TipoPeixe getTipo() {
		return tipo;
	}
	
	public String toString () {
		return "Peixe -> "+tipo+", "+super.toString();
	}
	
	public String whoAmI() {
		return "Peixe";
	}
	
	public boolean equals(Object obj) {
		if (obj==null || (getClass() != obj.getClass()) ) {
			return false;
		}
		if (obj==this) {
			return true;
		}
		
		Peixe p = (Peixe) obj;
		return (this.tipo == p.getTipo() && super.equals(p));
	}
}
