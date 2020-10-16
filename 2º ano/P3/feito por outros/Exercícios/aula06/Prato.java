package aula06;

public class Prato implements Comparable {

	private String nome;
	private Alimento[] composi�ao = new Alimento[100];
	private static int nAlimentos = 0;
	
	public Prato(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getNumAlimentos() {
		return nAlimentos;
	}
	
	public String toString() {
		return "Prato: "+nome;
	}
	
	public boolean addIngrediente(Alimento a) {
		composi�ao[nAlimentos] = a;
		nAlimentos++;
		
		return true;
	}
	
	public void listaAlimentos() {
		for (int i=0; i<nAlimentos; i++) {
			System.out.print(composi�ao[i]+" ");
		}
		System.out.println("");
	}
	
	public double getPesoTotal() {
		double pesoTotal = 0;
		for (int i=0; i<composi�ao.length; i++) {
			pesoTotal = pesoTotal + composi�ao[i].getPeso();
		}
		return pesoTotal;
	}
	
	public double getCaloriasTotal() {
		double caloriasTotal = 0;		// Por cada 100 gramas
		for (int i=0; i<composi�ao.length; i++) {
			caloriasTotal = caloriasTotal + composi�ao[i].getCalorias();
		}
		return caloriasTotal;
	}
	
	public double getProteinasTotal() {
		double proteinasTotal = 0;		// Por cada 100 gramas
		for (int i=0; i<composi�ao.length; i++) {
			proteinasTotal = proteinasTotal + composi�ao[i].getProteinas();
		}
		return proteinasTotal;
	}
	
	public int compareTo(Object obj) {
		Prato p = (Prato) obj;
		double difCalorias = getCaloriasTotal()-p.getCaloriasTotal();
		if (difCalorias==0) {
			return 0;
		}
		else if(difCalorias<0) {
			return -1;
		}
		else return 1;
	}
	
	public boolean equals(Object obj) {
		if (obj==null || (getClass() != obj.getClass()) ) {
			return false;
		}
		if (obj==this) {
			return true;
		}
		
		Prato a = (Prato) obj;
		return (this.nome == a.getNome());
	}
}
