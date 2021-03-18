package aula06;

public class PratoVegetariano extends Prato implements Vegetariano{

	public PratoVegetariano(String nome) {
		super(nome);
	}
	
	public String toString() {
		return "Prato Vegetariano: "+super.getNome();
	}

	public boolean addIngrediente(Vegetariano v) {
		Alimento a = (Alimento) v;
		
		super.addIngrediente(a);
		return true;
	}
	
	public boolean equals(Object obj) {
		if (obj==null || (getClass() != obj.getClass()) ) {
			return false;
		}
		if (obj==this) {
			return true;
		}
		
		PratoVegetariano a = (PratoVegetariano) obj;
		return (super.getNome() == a.getNome());
	}
}
