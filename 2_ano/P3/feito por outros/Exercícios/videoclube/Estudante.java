package videoclube;

public class Estudante extends Pessoa{

	private int numMec;
	private String curso;

	public Estudante() {
		super();
	}

	public void setEstudante(int inumMec, String icurso) {
		this.numMec = inumMec;
		this.curso = icurso;
	}

	public int getnumMec() {
		return this.numMec;
	}

	public String getcurso() {
		return this.curso;
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

	public void setnumMec(int inumMec) {
		this.numMec = inumMec;
	}

	public void setcurso(String icurso) {
		this.curso = icurso;
	}
	
	public String toString()
	{
		return "Nome: "+ super.getNome()+" BI: "+ super.getBi()+ "Data Nascimento: "+ super.getDataNasc()+"Nº Mecanográfico: "+ numMec+ " Curso:"+curso;
	}
}
