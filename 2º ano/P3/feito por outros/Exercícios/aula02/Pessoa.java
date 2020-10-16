package aula02;

public class Pessoa {
	//ATRIBUTOS
	private String nome;
	private int BI;
	private Data dataNasc;
	
	//CONSTRUTOR
	public Pessoa(String nome, int BI, Data dataNasc){
		this.nome = nome;
		this.BI=BI;
		this.dataNasc = dataNasc;
	}
	
	public String getNome(){
		return nome;
	}
	
	public int getBI(){
		return BI;
	}
	
	public Data getData(){
		return dataNasc;
	}
	
	public String dados(){
		return nome + " / " + BI + " / " + dataNasc.dataImp();
	}
	
}
