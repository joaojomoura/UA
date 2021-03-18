/**
 * 
 */
package aula3.ex3;
import static java.lang.System.*;

/**
 * @author João Moura
 *
 */
public abstract class Veiculo {
	
	private int cilindrada;
	private int potencia;
	private int lotacao;
	private String carta;
	private double peso;
	
	protected Veiculo(String c, int cl, int p, int l, double pe) {
		
		
		if(!c.equalsIgnoreCase("a") && !c.equalsIgnoreCase("b") && !c.equalsIgnoreCase("c") &&
				!c.equalsIgnoreCase("d")) 
			throw new IllegalArgumentException("Carta Invalida");
		
		carta = c;
		cilindrada = cl;
		potencia = p;
		lotacao = l;
		pe = peso;
		
	}

	/**
	 * @return the cilindrada
	 */
	public int getCilindrada() {
		return cilindrada;
	}

	/**
	 * @return the potencia
	 */
	public int getPotencia() {
		return potencia;
	}

	/**
	 * @return the lotacao
	 */
	public int getLotacao() {
		return lotacao;
	}

	/**
	 * @return the carta
	 */
	public String getCarta() {
		return carta;
	}

	/**
	 * @return the peso
	 */
	public double getPeso() {
		return peso;
	}
	


	
	public abstract String toString();
	public abstract boolean podeConduzir(Condutor c);
	
	
	
	

}
