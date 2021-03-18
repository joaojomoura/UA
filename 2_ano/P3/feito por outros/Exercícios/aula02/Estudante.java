package aula02;


public class Estudante extends Pessoa{
	
	private String curso;
	private int mec;

	
	
	
	public Estudante(String nome, int bi, Data dataNasc, int mec, String curso){
		super(nome,bi,dataNasc);
		this.mec = mec;
		this.curso = curso;
		
		
		
	}
	
	public String toString()
	{ 
		return "Nome: " + getNome() + " | BI: " + getBI() + " | Data Nasc.: " + getData() + " | MEC: " +mec +" | Curso: " +curso;
		
		
		
	}
	
	
	
	

	}

