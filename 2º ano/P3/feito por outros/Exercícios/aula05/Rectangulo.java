package aula05;

public class Rectangulo extends Figura {
	private double comprimento;
	private double largura;
	private Ponto centro;

	public Rectangulo() {
		centro = new Ponto();
	}

	public Rectangulo(Ponto centro, double largura, double comprimento) {
		this.centro = centro;
		this.largura = largura;
		this.comprimento = comprimento;
	}
	
	public Rectangulo(double x, double y, double largura, double comprimento) {
		centro = new Ponto(x,y);
		this.largura = largura;
		this.comprimento = comprimento;
	}
	
	public Rectangulo(double largura, double comprimento) {
		centro = new Ponto();
		this.largura = largura;
		this.comprimento = comprimento;
	}
	
	public Rectangulo(Rectangulo rectangulo) {
		centro = rectangulo.centro;
		largura = rectangulo.getLargura();
		comprimento = rectangulo.getComprimento();
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
	
	public String toString() {
		return "Rectangulo de Centro ("+centro.getX()+", "+centro.getY()+"), altura "+largura+", comprimento "+comprimento;
	}
	
	public boolean equals(Rectangulo a){	
		if(comprimento==a.comprimento && largura==a.largura && centro==a.centro)
			return true;
		
		return false;
	}
}
