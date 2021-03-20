/**
 * 
 */
package aula1.ex3;

/**
 * @author slowbro
 *
 */
public class Rectangle implements Operations_with_figures{
	
	/**
	 * Variables
	 */
	private double length, heigth;
	private Point p;
	
	/**
	 * Construtor
	 * @param length
	 * @param heigth
	 * @param p
	 */
	public Rectangle(double length, double heigth, Point p) {
		this.p = p;
		this.heigth = heigth;
		this.length = length;
	}
	
	/**
	 * Constructor
	 * @param length
	 * @param heigth
	 */
	public Rectangle(double length, double heigth) {
		this.heigth = heigth;
		this.length = length;
	}
	
	
	/**
	 * Constructor
	 * @param length
	 * @param heigth
	 * @param x
	 * @param y
	 */
	public Rectangle(double length, double heigth, double x, double y) {
		this.heigth = heigth;
		this.length = length;
		this.p = new Point(x, y);
	}
	
	/**
	 * Constructor with no arguments
	 */
	public Rectangle() {
		this(0, 0, new Point());
	}
	
	
	/***
	 * Operations with figures
	 */
	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return heigth * 2 + length *2 ;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return heigth * length;
	}

	/**
	 * @return the length
	 */
	public double getLength() {
		return length;
	}

	/**
	 * @return the heigth
	 */
	public double getHeigth() {
		return heigth;
	}

	/**
	 * @return the p
	 */
	public Point getP() {
		return p;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(heigth);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(length);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((p == null) ? 0 : p.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangle other = (Rectangle) obj;
		if (Double.doubleToLongBits(heigth) != Double.doubleToLongBits(other.heigth))
			return false;
		if (Double.doubleToLongBits(length) != Double.doubleToLongBits(other.length))
			return false;
		if (p == null) {
			if (other.p != null)
				return false;
		} else if (!p.equals(other.p))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "\nRectangulo\nComprimento: " + length + "\nAltura: " + heigth + "\nCentro; " + p.toString();
	}

}
