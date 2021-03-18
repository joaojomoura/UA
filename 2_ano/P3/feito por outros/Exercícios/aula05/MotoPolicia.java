package aula05;

public class MotoPolicia extends Moto implements Policia{
	private Tipo tipo;
	private static int idBase = 0;
	private int id;

	public MotoPolicia(int ano, String matricula, String corBase,
			int nrRodas, int cilindrada, int velocidadeMaxima, int potencia,
			int consumo, int combustivel, Tipo tipo) {
		
		super(ano, matricula, corBase, nrRodas, cilindrada, velocidadeMaxima, potencia,
				consumo, combustivel);
		this.tipo = tipo;
		idBase++; id = idBase;
	}
	
	public String toString() {
		return getTipo()+" -> "+super.toString()+getID();
	}
	
	public String getTipo() {
		return tipo.toString();
	}
	
	public String getID() {
		return ", ID_m: "+id;
	}
}
