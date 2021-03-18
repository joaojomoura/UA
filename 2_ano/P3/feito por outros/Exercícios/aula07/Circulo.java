package aula07;
import java.io.Serializable;

public class Circulo extends Figura implements Serializable{
	private static final long serialVersionUID = 4178078578168032667L;
	private double raio;
	private Ponto centro;

	public Circulo() {
		centro = new Ponto();
	}
	
	public Circulo(double raio) {
		centro = new Ponto();
		this.raio = raio;
	}
	
	public Circulo(double raio, Ponto centro) {
		this.raio = raio;
		this.centro = centro;
	}
	
	public Circulo(Ponto centro, double raio) {
		this.centro = centro;
		this.raio = raio;
	}
	
	public Circulo(double x, double y, double raio) {
		centro = new Ponto(x,y);
		this.raio = raio;
	}
	
	public Circulo(Circulo circulo) {
		raio = circulo.getRaio();
		centro = circulo.getCentro();
	}
	
	public double perimetro() {
		return 2 * Math.PI * raio;
	}
	
	public double area() {
		return Math.PI * raio * raio;
	}
	
	public double getRaio() {
		return raio;
	}
	
	public Ponto getCentro() {
		return centro;
	}
	
	public String toString() {
		return "Circulo de Centro ("+centro.getX()+", "+centro.getY()+") e de raio "+raio;
	}
}
