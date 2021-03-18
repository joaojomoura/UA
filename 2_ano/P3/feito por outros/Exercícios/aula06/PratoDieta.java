package aula06;

public class PratoDieta extends Prato {
	
	private static double calorias = 0;
	private double maxCalorias;

	public PratoDieta(String nome, double maxCalorias) {
		super(nome);
		this.maxCalorias = maxCalorias;
	}
	
	public String toString() {
		return "Prato Dieta: "+super.getNome()+", Máximo de Calorias: "+maxCalorias;
	}
	
	public boolean addIngrediente(Alimento a) {
		if ((calorias + a.getCalorias()) > maxCalorias) {
			return false;
		}
		else
		{
			super.addIngrediente(a);
			//calorias = calorias + a.getCalorias();
			return true;
		}
	}
	
	public boolean equals(Object obj) {
		if (obj==null || (getClass() != obj.getClass()) ) {
			return false;
		}
		if (obj==this) {
			return true;
		}
		
		PratoDieta a = (PratoDieta) obj;
		return (super.getNome() == a.getNome());
	}
}
