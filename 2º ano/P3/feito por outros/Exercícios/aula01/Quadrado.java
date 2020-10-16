package aula01;

public class Quadrado {

	private int l;
	
	public Quadrado(int lado) {
		l = lado;
	}

	public int area() {
		return l * l;
	}

	public int perimetro() {
		return l * 4;
	}
}
