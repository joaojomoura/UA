package aula03;

public class Bolseiro extends Estudante {
	public int montanteBolsa;
	
	public Bolseiro(String nome, int BI, Data dataNascimento, int mec, Data dataInsc) {
		super(nome, BI, dataNascimento, mec, dataInsc);
	}

	public Bolseiro(String nome, int BI, Data dataNascimento, int mec) {
		super(nome, BI, dataNascimento, mec);
	}

	public Bolseiro(String nome, int BI, Data dataNascimento) {
		super(nome, BI, dataNascimento);
	}
	
	public String whoAmI() {
		return "Bolseiro";
	}
	
	public int getBolsa() {
		return montanteBolsa;
	}
	
	public void setBolsa(int valor) {
		montanteBolsa = valor;
	}
	
	public String toString() {
		return super.toString() + ", Bolsa: " + montanteBolsa;
	}
}