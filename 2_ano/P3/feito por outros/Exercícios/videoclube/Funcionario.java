package videoclube;

public class Funcionario extends Pessoa{
	
	private int numFunc;
	private int nif;

	public Funcionario() {
		super();
	}

	public void setFuncionario(int inumFunc, int inif) {
		this.numFunc = inumFunc;
		this.nif = inif;
	}

	public int getnumFunc() {
		return this.numFunc;
	}

	public int getnif() {
		return this.nif;
	}

	public void setNome(String inome) {
		super.setNome(inome);

	}

	public void setBi(int ibi) {
		super.setBi(ibi);
	}

	public void setDataNasc(Data idataNasc) {
		if (idataNasc.isValid())
			super.setDataNasc(idataNasc);

	}

	public void setnumFunc(int inumFunc) {
		this.numFunc = inumFunc;
	}

	public void setnif(int inif) {
		this.nif = inif;
	}
	
	public String toString()
	{
		return "Nome: "+ super.getNome()+" BI: "+ super.getBi()+ "Data Nascimento: "+ super.getDataNasc()+"Nº Funcionario: "+ numFunc+ " NIF:"+nif;
	}
}
