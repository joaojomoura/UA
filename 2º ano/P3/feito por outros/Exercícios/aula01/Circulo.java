package aula01;

public class Circulo {

	private double raio;
	private Ponto2D centro;

	public Circulo() {
	}

	public Circulo(double raio) {
		this.raio = raio;
	}

	public Circulo(double x, double y, double raio) {
		centro = new Ponto2D(x, y);
		this.raio = raio;
	}

	public Circulo(int Raio, Ponto2D centro) {
		raio = Raio;
		this.centro = centro;
	}

	public Circulo(Circulo circulo) {
		this.centro = circulo.centro;
		this.raio = circulo.raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}

	public void setCentro(Ponto2D centro) {
		this.centro = centro;
	}

	public double getArea() {
		return Math.PI * (raio * raio);
	}

	public double getPerimetro() {
		return 2 * Math.PI * raio;
	}

	public Ponto2D getCentro() {
		return centro;
	}

	public double getRaio() {
		return raio;
	}

	public String toString() {
		return "Área: " + getArea() + "Perimetro: " + getPerimetro() + "X: " + getCentro().getX() + "Y: " + getCentro().getY();
	}
}
