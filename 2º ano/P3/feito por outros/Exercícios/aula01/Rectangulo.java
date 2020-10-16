package aula01;

public class Rectangulo {

	int c, l;
	
	public Rectangulo(int comprimento, int largura) {
		c = comprimento;
		l = largura;
	}
	
	public int area()
	{
		return c*l;
	}
	
	public int perimetro()
	{
		return c*2+l*2;
	}
	
}
