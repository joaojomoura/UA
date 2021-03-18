package aula03;

public class Rectangulo extends Figura {
	private double comprimento;
	private double largura;

	public Rectangulo() {
	}

	public Rectangulo(Ponto centro, double largura, double comprimento) {
		super(centro);
		this.largura = largura;
		this.comprimento = comprimento;
	}
	
	public Rectangulo(double x, double y, double largura, double comprimento) {
		super(new Ponto(x,y));
		this.largura = largura;
		this.comprimento = comprimento;
	}
	
	public Rectangulo(double largura, double comprimento) {
		this.largura = largura;
		this.comprimento = comprimento;
	}
	
	public Rectangulo(Rectangulo rectangulo) {
		this.largura = rectangulo.getLargura();
		this.comprimento = rectangulo.getComprimento();
	}
	
	public double getLargura() {
		return largura;
	}
	
	public double getComprimento() {
		return comprimento;
	}
	
	public double perimetro() {
		return 2*largura + 2*comprimento;
	}
	
	public double area() {
		return largura*comprimento;
	}
	
	/*public String toString() {
		return "Perimetro: " + perimetro() + ", Area: " + area();
	}*/
	
	public String toString() {
		return "Rectangulo: ";
	}
}
