package aula04;

public class Circulo extends Figura {
	private double raio;
	private Ponto centro;

	public Circulo() {
	}
	
	public Circulo(double raio) {
		super(new Ponto(0,0));
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
		
		this.raio = circulo.getRaio();
	}
	
	public String getCentro() {return "x: "+centro.getX()+" y: "+centro.getY();}
	
	public double getRaio(){return raio;}
	
	
	public double perimetro(){return 2 * Math.PI * raio;}
	
	public double area() {return Math.PI * raio * raio;}
	
	public String toString() {
		return "Circulo de Centro x: "+super.getX()+ ", y: "+super.getY()+" e de raio "+raio;
	}
	

}
