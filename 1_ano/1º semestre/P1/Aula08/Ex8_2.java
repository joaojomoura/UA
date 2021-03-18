//Aula 8 Ex 2

import java.util.Scanner;
import java.lang.Math;

public class Ex8_2{
	static final Scanner sc = new Scanner(System.in);

	public static void main (String [] args){

		Ponto2D origem = new Ponto2D();
		origem.x = 0;
		origem.y = 0;
		sumDistance(origem);
	}

	//ler coordenadas de um ponto
	public static Ponto2D lerPonto (){

		Ponto2D p = new Ponto2D ();

		System.out.println ("Introduza um ponto:");
		System.out.print ("Coordenada x: ");
		p.x = sc.nextDouble();
		System.out.print ("Coordenada y: ");
		p.y = sc.nextDouble();

		return p;
	}

	// imprime as coordenadas de um ponto (0.0, 0.0)
	public static void printPonto (Ponto2D tmp){

		System.out.printf ("(%.1f, %.1f)%n", tmp.x, tmp.y);
	}

	// distancia entre dois pontos
	public static double distance ( Ponto2D pontoA, Ponto2D pontoB){

		double x = Math.pow(pontoB.x,2) - Math.pow(pontoA.x,2); // (Xb - Xa)
		double y = Math.pow(pontoB.y,2) - Math.pow(pontoA.y,2);	// (Yb - Ya)

		double d = Math.sqrt (x + y); // distancia entre dois pontos

		return d;

	}

	//soma das distancias e retorna o ponto mais distante da origem
	public static void sumDistance (Ponto2D origem){

		double sum = 0, tmp_d = 0, d;
		int count = 0;
		Ponto2D tmp = new Ponto2D();
		Ponto2D ponto;

		do
		{
			ponto = lerPonto(); //pede um ponto
			d = distance (origem, ponto); // calcula a distancia do ponto a origem

			if(tmp_d < d)	//se a distancia for maior que a anterior substitui e guarda o ponto numa outra variavel
			{
				tmp_d = d;
				tmp.x = ponto.x;
				tmp.y = ponto.y;
			}
			sum = sum + d;	//soma das disntancias
			if (ponto.x != 0 && ponto.y != 0)
				count++;	//conta o numero de pontos 

		}while (ponto.x != 0.0 || ponto.y != 0.0);	//faz o ciclo enquanto a coordenada x e y sao diferentes de 0

		//impressao
		System.out.printf ("A soma das distâncias dos %d pontos à origem é %.1f%nO ponto mais afastado da origem foi: ", count, sum);
		printPonto(tmp);
		System.out.println();

	}
}


//class ponto com coordenadas x e y
class Ponto2D{
	double x, y;
}