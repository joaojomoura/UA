/**
 * 
 */
package aula5.ex2;

/**
 * @author Joao Moura
 *
 */
public class Automovel extends Veiculo implements Motorizado {

	private int potencia;
	private String matricula;
	private double consumo;
	private String combustivel;
	
	
	public Automovel(String mark, int year, int n, String colour, int pow, 
			String m, double cons, String fuel) {
		super(mark, year, n, colour);
		potencia = pow;
		matricula = m;
		consumo = cons;
		combustivel = fuel;
		
	}

	@Override
	public int getPotencia() {
		
		return potencia;
	}

	@Override
	public String getMatricula() {
		
		return matricula;
	}

	@Override
	public double getConsumo() {
		
		return consumo;
	}

	@Override
	public String getCombustivel() {
		
		return combustivel;
	}

	@Override
	public String toString() {
		
		return "Automovel \n Marca: " + super.getMarca() + " Ano: " + super.getAno()
		+ " Rodas: " + super.getNrodas() + " Cor: " + super.getCor() + " Matricula: " + matricula +
		" Potencia: " + potencia + " Combustivel: " + combustivel + " Consumo: " + consumo;
	}

}
