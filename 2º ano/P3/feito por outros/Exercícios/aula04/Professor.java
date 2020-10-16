package aula04;

public class Professor extends Pessoa {
	private int nFunc;
	private static int nProfessores = 1;
	private Data dataAdmissao;
	
	public Professor(String nome, int bi, Data dataNascimento) {
		super(nome, bi, dataNascimento);
		nFunc = nProfessores;
		dataAdmissao = new Data();
		nProfessores++;
	}
	
	public int getNFunc() {
		return nFunc;
	}
	
	public Data getDataAdmissao() {
		return dataAdmissao;
	}
	
	public String toString() {
		return super.toString() + ", NMec: " + nFunc + ", Admitido em Data: " + dataAdmissao;
	}
}
