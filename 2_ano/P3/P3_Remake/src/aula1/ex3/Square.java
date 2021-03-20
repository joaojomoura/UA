/**
 * 
 */
package aula1.ex3;

/**
 * @author slowbro
 *
 */
public class Square extends Rectangle {

	/**
	 * Constructor
	 * @param l
	 * @param p
	 */
	public Square(double l, Point p) {
		super(l, l, p);
	}
	
	/**
	 * Constructor
	 * @param l
	 * @param x
	 * @param y
	 */
	public Square(double l, double x, double y) {
		this(l, new Point(x, y));
	}
	
	/**
	 * Constructor with no arguments
	 */
	public Square() {
		this(0, new Point());
	}
	
	/**
	 * Constructor
	 * @param l
	 */
	public Square(double l) {
		this(l, new Point());
	}
	
	@Override
	public String toString() {
		return "\nQuadrado\nLado: " + super.getLength() + "\nCentro: " + super.getP();
	}

}
