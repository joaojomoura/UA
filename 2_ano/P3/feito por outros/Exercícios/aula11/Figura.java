package aula11;

public abstract class Figura implements Comparable {
	private Ponto centro;
	
	public Figura() {
		centro = new Ponto();
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
	
	public abstract double area();
	public abstract double perimetro();
	
	
	public int compareTo(Object obj) {
		Figura f = (Figura) obj;
		double difArea = area()-f.area();
		if (difArea==0) {
			return 0;
		}
		else if (difArea<0) {
			return -1;
		}
		else return 1;
	}
}
