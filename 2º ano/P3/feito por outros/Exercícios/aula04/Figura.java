package aula04;

public class Figura {
	private Ponto centro;
	
	public Figura() {
	}
	
	public Figura (Ponto centro) {
		this.centro = centro;
	}
	
	public String getCentro() {
		return "x: "+centro.getX()+" y: "+centro.getY();
	}
	
	public double getX() {
		return centro.getX();
	}

	public double getY() {
		return centro.getY();
	}
	
	public String toString() {
		return "Centro: " + getCentro();
	}
}
