package aula02;


public class Funcionario extends Pessoa {
	private int nFunc, nFisc;
	
	public Funcionario(String nome, int BI, Data dataNasc, int nFunc, int nFisc){
		super(nome,BI,dataNasc);
	
		this.nFunc = nFunc;
		this.nFisc = nFisc;
		
		
	}
	
	public String toString()
	{ 
		return "Nome: " + getNome() + " | BI: " + getBI() + " | Data Nasc.: " + getData() + " | Nº Func.: " + nFunc + " | Nº Fisc.: " +nFisc;
		
	} 
	

}
