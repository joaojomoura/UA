/**
 * 
 */
package aula3.ex3;

/**
 * @author João Moura
 *
 */
public class Ligeiro extends Veiculo{

	public Ligeiro(String c, int cl, int p, int l, double pe) throws IllegalAccessException{
		super(c, cl, p, l, pe);
		if(c.equalsIgnoreCase("a"))
			throw new IllegalAccessException("Carta errada.");
	}
	
	@Override
	public String toString()
	{
		return "Veículo ligeiro:\n\t-> Potência: " + super.getPotencia() + "\n\t-> Cilindrada: " + 
	super.getCilindrada() + "\n\t-> Peso Bruto: " + super.getPeso() + "\n\t-> Lotação: " + super.getLotacao();
	}
	
	@Override
	public boolean podeConduzir(Condutor c) {
		return (c.getCartaConducao()).equalsIgnoreCase("A") ? false : true;
	}

}
