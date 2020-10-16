package videoclube;

public class Utilizador {
	private int num_soc;
	private Data dataInsc;
	private static int serial=0;
	private Pessoa u;
	
	
	public Utilizador(Pessoa iu)
	{
		this.dataInsc=new Data();
		this.num_soc=++serial;
		this.u=iu;
	}
	
	public void setCliente(int inum_soc, Data idataNasc, Pessoa iu)
	{
		this.dataInsc=idataNasc;
		this.num_soc=inum_soc;
		this.u=iu;
	}
	
	public int getNum_soc()
	{
		return this.num_soc;
	}
	
	public int getBI()
	{
		return this.u.getBi();
	}
	public String getNome()
	{
		return this.u.getNome();
	}
	
	public Data getdataInsc()
	{
		return this.dataInsc;
	}
	
	public Pessoa getTipoU()
	{
		return this.u;
	}
	
	public String toString()
	{
		String s="NºSócio: "+ num_soc+"  Data Inscrição: "+getdataInsc()+"( ";
		
		if (this.u instanceof Funcionario) {
			s+=((Funcionario)this.u).toString();
		}else{
			s+=((Estudante)this.u).toString();
			
		}
		s+=" )";
		return s;
	}
}
