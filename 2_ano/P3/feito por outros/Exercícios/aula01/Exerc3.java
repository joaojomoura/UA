package aula01;
import java.util.*;
public class Exerc3 {


	final static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int op;
		
		while(true){
			op=menu1();
			switch(op){
			case 0:	System.exit(0);	break;
			case 1: quadrado(); break;
			case 2: rectangulo(); break;
			case 3: circulo(); break;
			
			}
		}
	}
	

	static int menu1(){
		
		System.out.println("1: Quadrado.");
		System.out.println("2: Rectângulo.");
		System.out.println("3: Circulo.");
		System.out.println("0: Sair.");
		System.out.println();
		
		int tmp = s.nextInt();
		return tmp;
	}
	
	static int menu2(){
		
		System.out.println();
		System.out.println("1 - Calcular área e perímetro.");
		System.out.println("2 - Verificar se são iguais.");
		System.out.println("3 - Verificar se se interceptam.");
		System.out.println("0 - Voltar.");
		
		int tmp = s.nextInt();
		return tmp;
	}
	
	static void quadrado() {
		System.out.println("Lado do quadrado: ");
		int l = s.nextInt();
		Quadrado q = new Quadrado(l);
		System.out.println("A área do quadrado é: " + q.area());
		System.out.println("O perimetro do quadrado é: " + q.perimetro());
		
	}
	
	
	static void rectangulo() {
		System.out.println("Largura do rectangulo: ");
		int l =s.nextInt();
		System.out.println("Comprimentos do rectangulo: ");
		int c = s.nextInt();
		Rectangulo r = new Rectangulo(c,l);
		System.out.println("A área do rectangulo é: " + r.area());
		System.out.println("O perimetro do rectangulo é: " + r.perimetro());
		
		
	}
	
	static void circulo() {
		int op;
		
		do{
		op = menu2();
		 switch(op){
		 case 1: circuloCalc(); break;
		 case 2: circuloIguais(); break;
		 case 3: circuloInters(); break;
		 
		 
		 
		 }
		
		
		}while(op!=0);
	}


	static void circuloCalc() {
		System.out.println("Raio do circulo: ");
		double r = s.nextDouble();
		Circulo c = new Circulo(r);
		System.out.println("A área do circulo é: " + c.getArea());
		System.out.println("O perimetro do circulo é: "	+ c.getPerimetro());
	}


	static void circuloIguais() {
		System.out.println("CIRCULO 1:");
		Circulo c1 = lerCirculo();
		System.out.println("CIRCULO 2:");
		Circulo c2 = lerCirculo();
		
		if (c1.getArea() == c2.getArea() && c1.getPerimetro() == c2.getPerimetro())
			System.out.println("Os circulos são iguais");
		else
			System.out.println("Os circulos não são iguais");
		
		
		
	}


	static void circuloInters() {
		System.out.println("CIRCULO 1:");
		Circulo c1 = lerCirculo();
		System.out.println("CIRCULO 2:");
		Circulo c2 = lerCirculo();
		
		double distCentrosX = Math.abs(c1.getCentro().getX()
				- c2.getCentro().getX());
		double distCentrosY = Math.abs(c1.getCentro().getY()
				- c2.getCentro().getY());
		double distCentros = Math.sqrt(distCentrosX * distCentrosX
				+ distCentrosY * distCentrosY);

		if (c1.getRaio() + c2.getRaio() >= distCentros)
			System.out.println("Os circulos interseptam-se.");
		else
			System.out.println("Os circulos não interseptam-se.");
		
	}
	
	static Circulo lerCirculo(){
		
		System.out.println("Raio do circulo: ");
		double raio=s.nextDouble();

		System.out.println("Posição do centro no eixo dos X: ");
		double x=s.nextDouble();
		
		System.out.println("Posição do centro no eixo dos Y: ");
		double y=s.nextDouble();
		
		Circulo c = new Circulo(x, y, raio);

		return c;
		
	}
	
}
