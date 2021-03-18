package videoclube;

public class Pessoa {
	private String nome;
	private int bi;
	private Data dataNasc;
	
	
	public Pessoa()
	{
		
	}
	public Pessoa(String inome, int ibi, Data idataNasc)
	{
		this.nome=inome;
		this.bi=ibi;
		this.dataNasc=idataNasc;
	}
	
	public String getNome()
	{
		return this.nome;
	}
	
	public int getBi()
	{
		return this.bi;
	}
	
	public Data getDataNasc()
	{
		return this.dataNasc;
	}
	
	public void setNome(String inome)
	{
		this.nome=inome;
		
	}
	
	public void setBi(int ibi)
	{
		this.bi=ibi;
	}
	
	public void setDataNasc(Data idataNasc)
	{
		if (idataNasc.isValid())
			this.dataNasc=idataNasc;
		
	}
	public String toString(){
		return this.nome+", "+this.bi+", "+this.dataNasc;
	}

}
