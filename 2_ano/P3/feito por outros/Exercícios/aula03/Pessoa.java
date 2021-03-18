package aula03;

public class Pessoa {
	private String nome;
	private int bi;
	private Data dataNasc;
	
	public Pessoa(String nome, int bi, Data dataNascimento){
		this.nome = nome;
		this.bi=bi;
		this.dataNasc = dataNascimento;
	}
	
	public String getNome(){
		return nome;
	}
	
	public String whoAmI() {
		return "Pessoa";
	}
	
	public String getName() {
		return getClass().toString();
	}
	
	public int getBI(){
		return bi;
	}
	
	public Data getData(){
		return dataNasc;
	}
	
	public String toString(){
		return nome + ", BI: " + bi + ", DataNasc: " + dataNasc.toString();
	}	
}