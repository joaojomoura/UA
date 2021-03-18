package aula11;
import java.io.Serializable;

public class Pessoa implements Serializable{
	private static final long serialVersionUID = 759215895287046898L;
	private String nome;
	private int BI;
	private Data dataNasc;
	
	public Pessoa(String nome, int BI, Data dataNascimento){
		this.nome = nome;
		this.BI=BI;
		this.dataNasc = dataNascimento;
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
	
	public String toString(){
		return nome + " / " + BI + " / " + dataNasc.toString();
	}
	
}
