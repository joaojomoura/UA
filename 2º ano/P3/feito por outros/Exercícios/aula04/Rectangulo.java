package aula04;

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
		super(new Ponto(0,0));
		this.largura = largura;
		this.comprimento = comprimento;
	}
	
	public Rectangulo(Rectangulo rectangulo) {
		super(new Ponto(0,0));
		this.largura = rectangulo.getLargura();
		this.comprimento = rectangulo.getComprimento();
	}
	
	public double getLargura() {return largura;}	
	public double getComprimento(){return comprimento;}
	public double getX(){return super.getX();}
	public double getY(){return super.getY();}
	
	public double perimetro() {
		return 2*largura + 2*comprimento;
	}
	
	public double area() {
		return largura*comprimento;
	}
	
	public String toString() {
		return "Rectangulo de Centro x: "+super.getX()+ ", y: "+super.getY()+", altura "+largura+", comprimento "+comprimento;
	}
	
	public boolean equals(Rectangulo a){
		
		if(comprimento==a.comprimento && largura==a.largura && getX()==a.getX() && getY()==a.getY())
			return true;
		
		return false;
	}
	

}
