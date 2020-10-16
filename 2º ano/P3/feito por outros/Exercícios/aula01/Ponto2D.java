package aula01;

public class Ponto2D {


	private double x, y;

	public Ponto2D() { }

	public Ponto2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Ponto2D(Ponto2D centro) {
		this.x = centro.getX();
		this.y = centro.getY();
	}

	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
}
