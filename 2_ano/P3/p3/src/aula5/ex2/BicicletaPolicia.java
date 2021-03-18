/**
 * 
 */
package aula5.ex2;

/**
 * @author João Moura
 *
 */
public class BicicletaPolicia extends Bicicleta implements Policia {
	
	private Tipo tipo;
	private int id;
	

	/**
	 * @param mark
	 * @param year
	 * @param n
	 * @param colour
	 */
	public BicicletaPolicia(String mark, int year, int n, String colour, Tipo t, int idCop) {
		super(mark, year, n, colour);
		tipo = t;
		id = idCop;
		
	}

	@Override
	public Tipo getTipo() {
		// TODO Auto-generated method stub
		return tipo;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return ", ID: " + id;
	}
	
	@Override
	public String toString() {
		return getTipo() + "- > " + super.toString() + getID();
	}

}
