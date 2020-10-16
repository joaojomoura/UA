package aula05;

public class Veiculo implements Comparable{
	private int ano;
	private String matricula;
	private String corBase;
	private int nrRodas;
	private int cilindrada;
	private int velocidadeMaxima;
	private int potencia;
	private int consumo;
	private int combustivel;

	public Veiculo(int ano, String matricula, String corBase, int nrRodas,
			int cilindrada, int velocidadeMaxima, int potencia, int consumo,
			int combustivel) {
		
		this.ano = ano;
		this.matricula = matricula;
		this.corBase = corBase;
		this.nrRodas = nrRodas;
		this.cilindrada = cilindrada;
		this.velocidadeMaxima = velocidadeMaxima;
		this.potencia = potencia;
		this.consumo = consumo;
		this.combustivel = combustivel;
	}
	
	public String toString() {
		return "Ano: "+ano+", Matrícula: "+matricula+", Cor: "+corBase+", Nº Rodas: "+nrRodas+", Cilindrada: "
			+cilindrada+", Velocidade Máx: "+velocidadeMaxima+", Potência: "+potencia+", Consumo: "+consumo
			+", Combustivel: "+combustivel;
	}

	public int compareTo(Object obj) {
		Veiculo v = (Veiculo) obj;
		double difAno = getAno()-v.getAno();
		if (difAno==0) {
			return 0;
		}
		else if (difAno<0) {
			return -1;
		}
		else return 1;
	}
	
	public int getAno() {
		return ano;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getCorBase() {
		return corBase;
	}

	public int getNrRodas() {
		return nrRodas;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public int getVelocidadeMaxima() {
		return velocidadeMaxima;
	}

	public int getPotencia() {
		return potencia;
	}

	public int getConsumo() {
		return consumo;
	}

	public int getCombustivel() {
		return combustivel;
	}
}
