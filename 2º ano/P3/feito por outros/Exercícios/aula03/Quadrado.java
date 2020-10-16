package aula03;

public class Quadrado extends Figura {
	private double lado;

	public Quadrado() {
	}

	public Quadrado(Ponto centro, double lado) {
		super(centro);
		this.lado = lado;
	}
	
	public Quadrado(double x, double y, double lado) {
		super(new Ponto(x,y));
		this.lado = lado;
	}
	
	public Quadrado (double lado) {
		this.lado = lado;
	}
	
	public Quadrado (Quadrado quadrado) {
		this.lado = quadrado.getLado();
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
	
	/*public String toString() {
		return "Perimetro: " + perimetro() + ", Area: " + area();
	}*/
	
	public String toString() {
		return "Quadrado: ";
	}
}
