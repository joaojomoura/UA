/**
 * 
 */
package aula3.ex3;

/**
 * @author Joao Moura
 *
 */
public class PesadoMercadorias extends Veiculo{

	public PesadoMercadorias(String c, int cl, int p, int l, double pe) throws IllegalAccessException{
		super(c, cl, p, l, pe);
		if(c.equalsIgnoreCase("a") || c.equalsIgnoreCase("b"))
			throw new IllegalAccessException("Carta errada.");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Pesado de Mercadorias:\n\t-> Potência: " + super.getPotencia() + "\n\t-> Cilindrada: " + 
				super.getCilindrada() + "\n\t-> Peso Bruto: " + super.getPeso() + "\n\t-> Lotação: " + super.getLotacao();
	}
	
	@Override
	public boolean podeConduzir(Condutor c) {
		return ((c.getCartaConducao()).equalsIgnoreCase("A") 
				|| c.getCartaConducao().equalsIgnoreCase("B")) ? false : true;
	}

}
