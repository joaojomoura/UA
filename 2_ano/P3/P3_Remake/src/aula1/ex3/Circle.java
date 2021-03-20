/**
 * 
 */
package aula1.ex3;

/**
 * @author slowbro
 *
 */
public class Circle implements Operations_with_figures{

	/**
	 * Variables
	 */
	private double r;
	private Point center;
	
	/**
	 * Constructor
	 * @param r
	 * @param center
	 */
	public Circle(double r, Point center) {
		this.center = center;
		this.r = r;
	}
	
	/**
	 * Constructor
	 * @param r
	 * @param x
	 * @param y
	 */
	public Circle(double r, double x, double y) {
		this(r, new Point(x, y));
	}
	
	/**
	 * Constructor
	 * @param r
	 */
	public Circle(double r) {
		this(r, new Point());
	}
	
	/**
	 * Constructor with no arguments
	 */
	public Circle() {
		this(0, new Point());
	}
	
	
	
	/**
	 * Operations with circles
	 */
	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return Math.PI * 2 * r;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return Math.PI * r * r;
	}
	
	public boolean compare(Circle comp) {
		return (this.equals(comp));
	}
	
	public boolean intersect(Circle comp) {
		return (center.distance(comp.center) <= r);
	}

	
		
	
	/**
	 * @return the r
	 */
	public double getR() {
		return r;
	}

	/**
	 * @return the center
	 */
	public Point getCenter() {
		return center;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((center == null) ? 0 : center.hashCode());
		long temp;
		temp = Double.doubleToLongBits(r);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Circle other = (Circle) obj;
		if (center == null) {
			if (other.center != null)
				return false;
		} else if (!center.equals(other.center))
			return false;
		if (Double.doubleToLongBits(r) != Double.doubleToLongBits(other.r))
			return false;
		return true;
	}
	
	public String toString() {
		return "\nCirculo\nRaio: " + r + "\nCenter: " + center;
	}
	
	

}
