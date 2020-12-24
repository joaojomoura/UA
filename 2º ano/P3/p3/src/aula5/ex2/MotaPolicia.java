/**
 * 
 */
package aula5.ex2;

/**
 * @author João Moura
 *
 */
public class MotaPolicia extends Mota implements Policia {
	private Tipo tipo;
	private int id;

	/**
	 * @param mark
	 * @param year
	 * @param n
	 * @param colour
	 * @param pow
	 * @param m
	 * @param cons
	 * @param fuel
	 */
	public MotaPolicia(String mark, int year, int n, String colour, int pow, 
			String m, double cons, String fuel, Tipo t, int idCop) {
		super(mark, year, n, colour, pow, m, cons, fuel);
		// TODO Auto-generated constructor stub
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
