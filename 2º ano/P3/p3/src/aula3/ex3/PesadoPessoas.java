/**
 * 
 */
package aula3.ex3;

/**
 * @author João Moura
 *
 */
public class PesadoPessoas extends Veiculo{

	public PesadoPessoas(String c, int cl, int p, int l, double pe) throws IllegalAccessException{
		super(c, cl, p, l, pe);
		if(c.equalsIgnoreCase("a") || c.equalsIgnoreCase("b") || c.equalsIgnoreCase("c"))
			throw new IllegalAccessException("Carta errada.");
		
	}

	@Override
	public String toString() {
		
		return "Pesado de passageiros:\n\t-> Potência: " + super.getPotencia() + "\n\t-> Cilindrada: " + 
		super.getCilindrada() + "\n\t-> Peso Bruto: " + super.getPeso() + "\n\t-> Lotação: " + super.getLotacao();
	}

	@Override
	public boolean podeConduzir(Condutor c) {
		return ((c.getCartaConducao()).equalsIgnoreCase("A") 
				|| c.getCartaConducao().equalsIgnoreCase("B")
				|| c.getCartaConducao().equalsIgnoreCase("C")) ? false : true;
	}	
	
}
