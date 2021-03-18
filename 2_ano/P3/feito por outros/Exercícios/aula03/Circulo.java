package aula03;

public class Circulo extends Figura {
	private double raio;
	private Ponto centro;

	public Circulo() {
	}
	
	public Circulo(double raio) {
		this.raio = raio;
	}
	
	public Circulo(double raio, Ponto centro) {
		this.raio = raio;
		this.centro = centro;
	}
	
	public Circulo(Ponto centro, double raio) {
		super(centro);
		this.raio = raio;
	}
	
	public Circulo(double x, double y, double raio) {
		super(new Ponto(x,y));
		this.raio = raio;
	}
	
	public Circulo(Circulo circulo) {
		super(circulo.getCentro());
		this.raio = circulo.getRaio();
	}
	
	public double getRaio() {
		return raio;
	}
	
	public Ponto getCentro() {
		return centro;
	}
	
	public double perimetro() {
		return 2 * Math.PI * raio;
	}
	
	public double area() {
		return Math.PI * raio * raio;
	}
	
	/*public String toString() {
		return "Perimetro: " + perimetro() + ", Area: " + area();
	}*/
	
	public String toString() {
		return "Circulo: ";
	}
}
