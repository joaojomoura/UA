/**
 * 
 */
package aula5.ex2;

/**
 * @author Joao Moura
 *
 */
public class Bicicleta extends Veiculo{

	public Bicicleta(String mark, int year, int n, String colour) {
		super(mark, year, n, colour);
		
	}

	

	@Override
	public String toString() {
		
		return "Bicicleta \n Marca: " + super.getMarca() + " Ano: " + super.getAno()
		+ " Rodas: " + super.getNrodas() + " Cor: " + super.getCor();
	}
	

}
