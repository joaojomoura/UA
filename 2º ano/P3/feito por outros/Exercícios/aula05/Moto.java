package aula05;

public class Moto extends VeiculoMotorizado {

	public Moto(int ano, String matricula, String corBase, int nrRodas,
			int cilindrada, int velocidadeMaxima, int potencia, int consumo,
			int combustivel) {
		
		super(ano, matricula, corBase, nrRodas, cilindrada, velocidadeMaxima, potencia,
				consumo, combustivel);
	}
	
	public String toString() {
		return "MOTO -> "+super.toString();
	}
}
