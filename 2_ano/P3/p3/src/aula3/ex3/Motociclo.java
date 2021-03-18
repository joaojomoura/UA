/**
 * 
 */
package aula3.ex3;

/**
 * @author João Moura
 *
 */
public class Motociclo extends Veiculo{

	public Motociclo(String c, int cl, int p, int l, double pe) throws IllegalAccessException{
		super(c, cl, p, l, pe);
	}

	@Override
	public String toString() {
		
		return "Motociclo:\n\t-> Potência: " + super.getPotencia() + "\n\t-> Cilindrada: " + super.getCilindrada() + 
				"\n\t-> Peso Bruto: " + super.getPeso() + "\n\t-> Lotação: " + super.getLotacao();
	}
	
	@Override
	public boolean podeConduzir(Condutor c) {
		return true;
	}
	

}
