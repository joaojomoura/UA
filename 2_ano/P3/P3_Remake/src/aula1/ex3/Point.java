/**
 * 
 */
package aula1.ex3;

/**
 * @author slowbro
 *
 */
public class Point {
	
	/**
	 * Variables
	 */
	private double x, y;
	
	
	/**
	 * Constructor with
	 * @param x
	 * @param y
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Constructor with no arguments
	 */
	public Point () {
		this(0,0);
	}

	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
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
		Point other = (Point) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}
	
	public double distance(Point p) {
		return Math.sqrt(Math.pow(this.x + p.x, 2) - Math.pow(this.y - p.y, 2));
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

}
