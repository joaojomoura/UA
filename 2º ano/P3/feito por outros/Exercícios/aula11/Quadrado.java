package aula11;

public class Quadrado extends Rectangulo {
	private double lado;
	private Ponto centro;

	public Quadrado() {
		centro = new Ponto();
	}

	public Quadrado(Ponto centro, double lado) {
		this.centro = centro;
		this.lado = lado;
	}
	
	public Quadrado(double x, double y, double lado) {
		centro = new Ponto(x,y);
		this.lado = lado;
	}
	
	public Quadrado (double lado) {
		centro = new Ponto();
		this.lado = lado;
	}
	
	public Quadrado (Quadrado quadrado) {
		this.lado = quadrado.getLado();
		centro = new Ponto();
	}
	
	public double getLado() {
		return lado;
	}
	
	public double perimetro() {
		return 4 * lado;
	}
	
	public double area() {
		return lado * lado;
	}
	
	public String toString() {
		return "Quadrado de Centro ("+centro.getX()+", "+centro.getY()+"), lado "+lado;
	}
	
	
}
