package aula07;
import java.io.Serializable;

public class Ponto implements Serializable{
	private static final long serialVersionUID = -8482155569599454975L;
	private double x, y;

	public Ponto() {
		x = 0;
		y = 0;
	}

	public Ponto(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Ponto(Ponto centro) {
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