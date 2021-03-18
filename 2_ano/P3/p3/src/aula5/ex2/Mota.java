/**
 * 
 */
package aula5.ex2;

/**
 * @author João Moura
 *
 */
public class Mota extends Veiculo implements Motorizado {
	
	private int potencia;
	private String matricula;
	private double consumo;
	private String combustivel;

	/**
	 * @param mark
	 * @param year
	 * @param n
	 * @param colour
	 */
	public Mota(String mark, int year, int n, String colour,int pow, 
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
		
		return "Mota \n Marca: " + super.getMarca() + " Ano: " + super.getAno()
		+ " Rodas: " + super.getNrodas() + " Cor: " + super.getCor() + " Matricula: " + matricula +
		" Potencia: " + potencia + " Combustivel: " + combustivel + " Consumo: " + consumo;
	}

}
