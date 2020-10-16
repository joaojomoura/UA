package aula04;

public class Pessoa {
	private String nome;
	private int bi;
	private Data dataNasc;
	
	public Pessoa(String nome, int bi, Data dataNascimento){
		this.nome = nome;
		this.bi=bi;
		this.dataNasc = dataNascimento;
	}
	
	public Pessoa(String nome) {
		this.nome = nome;
	}
	
	public String getName(){
		return nome;
	}
	
	public String whoAmI() {
		return "Pessoa";
	}
	
	public int getBI(){
		return bi;
	}
	
	public Data getData(){
		return dataNasc;
	}
	
	public String toString(){
		return nome + ", BI: " + bi + ", Nascido na Data: " + dataNasc;
	}	
}