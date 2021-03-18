package aula03;

public class Figura {
	private Ponto centro;
	
	public Figura() {
	}
	
	public Figura (Ponto centro) {
		this.centro = centro;
	}
	
	public Ponto getCentro() {
		return centro;
	}
	
	public String toString() {
		return "Centro: " + getCentro();
	}
}
