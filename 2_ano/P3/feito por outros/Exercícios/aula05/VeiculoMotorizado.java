package aula05;

public class VeiculoMotorizado extends Veiculo implements Motorizado{

	public VeiculoMotorizado(int ano, String matricula, String corBase,
			int nrRodas, int cilindrada, int velocidadeMaxima, int potencia,
			int consumo, int combustivel) {
		
		super(ano, matricula, corBase, nrRodas, cilindrada, velocidadeMaxima,
				potencia, consumo, combustivel);
	}
	
	public int getPotencia() {
		return super.getPotencia();
	}
	
	public int getConsumo() {
		return super.getConsumo();
	}
	public int getCombustivel() {
		return super.getCombustivel();
	}
}
