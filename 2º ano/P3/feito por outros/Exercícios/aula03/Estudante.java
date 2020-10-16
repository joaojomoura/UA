package aula03;

public class Estudante extends Pessoa {
	private static int nMecBase = 100;
	private int nMec;
	private Data dataInsc;
	
	public Estudante(String nome, int BI, Data dataNascimento, int nMeci, Data dataInsc) {
		super(nome, BI, dataNascimento);
		this.nMec = nMecBase++;
		this.dataInsc = dataInsc;
	}
	
	public Estudante(String nome, int BI, Data dataNascimento, int nMeci) {
		super(nome, BI, dataNascimento);
		this.nMec = nMecBase++;
		this.dataInsc = new Data();
	}
	
	public Estudante(String nome, int BI, Data dataNascimento) {
		super(nome, BI, dataNascimento);
		this.nMec = nMecBase++;
		this.dataInsc = new Data();
	}
	
	public int getEstNum() {
		return nMec;
	}
	
	public String whoAmI() {
		return "Estudante";
	}
	
	public Data getDataInsc() {
		return dataInsc;
	}
	
	public String toString() {
		return super.toString() + ", NMec: " + nMec + ", Data Inscrição: " + dataInsc;
	}
}