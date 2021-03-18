package aula06;

public class Alimento {

	private double proteinas;
	private double calorias;
	private double peso;
	
	public Alimento(double proteinas, double calorias, double peso) {
		this.proteinas = proteinas;
		this.calorias = calorias;
		this.peso = peso;
	}
	
	public double getProteinas() {
		return proteinas;
	}

	public double getCalorias() {
		return calorias;
	}

	public double getPeso() {
		return peso;
	}
	
	public String toString() {
		return "Proteinas: "+proteinas+", Calorias: "+calorias+", Peso: "+peso;
	}
	
	public String whoAmI() {
		return "Alimento";
	}
	
	public boolean equals(Object obj) {
		if (obj==null || (getClass() != obj.getClass()) ) {
			return false;
		}
		if (obj==this) {
			return true;
		}
		
		Alimento a = (Alimento) obj;
		return (this.proteinas == a.getProteinas() && this.calorias == a.getCalorias() && this.peso == a.getPeso());
	}
}
