package aula1.ex3;
import java.util.*;
import static java.lang.System.*;


public class Teste {
	final static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circulo circ = new Circulo (new Ponto(1,1), 10);
		Circulo circ2 = new Circulo(4,2,20);
		Quadrado quads = new Quadrado(4, new Ponto(2, 3));
		Rectangulo ret = new Rectangulo(10, 12, new Ponto(0, 0));
		
		
		
		out.println(quads.area());
		out.println(quads.perimetro());
		out.println(ret.area());
		out.println(ret.perimetro());
		out.println();
		out.println(circ.area());
		out.println(circ.perimetro());
		out.println(circ2.area());
		out.println(circ2.perimetro());
		out.println(circ.toString());
		out.println(circ.equals(circ2));
		out.println(circ.interception(circ2));

	}	
}
