//Aula 8 Ex 4

import java.util.Scanner;
import java.lang.Math;

public class Ex8_4 {

	static Scanner sc = new Scanner (System.in);

	public static void main (String [] args) {

		char c = ' ';
		Complexo comp1, comp2, result;

		//loop until the char c is '='
		do {
			System.out.print("Operação: ");
			c = sc.next().charAt(0);
			
			switch(c) {	
				case '+' :
					comp1 = read_comp();
					comp2 = read_comp();
					result = add(comp1, comp2);
					print_comp(comp1);
					System.out.print(" + ");
					print_comp(comp2);
					System.out.print(" = ");
					print_comp(result);
					System.out.println();
					break;

				case '-' :
					comp1 = read_comp();
					comp2 = read_comp();
					result = sub(comp1, comp2);
					print_comp(comp1);
					System.out.print(" + ");
					print_comp(comp2);
					System.out.print(" = ");
					print_comp(result);
					System.out.println();
					break;

				case '*' :
					comp1 = read_comp();
					comp2 = read_comp();
					result = mul(comp1, comp2);
					print_comp(comp1);
					System.out.print(" + ");
					print_comp(comp2);
					System.out.print(" = ");
					print_comp(result);
					System.out.println();
					break;

				case '/' :
					comp1 = read_comp();
					comp2 = read_comp();
					result = div(comp1, comp2);
					print_comp(comp1);
					System.out.print(" + ");
					print_comp(comp2);
					System.out.print(" = ");
					print_comp(result);
					System.out.println();
					break;

				case '=' :
					System.out.println("O programa vai terminar...");
					break;

				default:
					System.out.println("Operação não permitida!");
					break;
 			}

		}while(c != '=');


	}

	//function to read the number (real and imaginary part)
	public static Complexo read_comp () {
		
		Complexo comp = new Complexo ();

		System.out.println("Introduza um numero complexo:");
		System.out.print("Parte real: ");
		comp.r = sc.nextDouble();						//real number
		System.out.print("Parte imaginaria: ");
		comp.i = sc.nextDouble();						//imaginary number

		return comp;
	}

	//fuction to print te complex number
	public static void print_comp (Complexo comp) {
		
		if(comp.i >= 0)
			System.out.printf("%.1f+%.1fi", comp.r, comp.i); //if the i number is larger or equal to 0, add the symbol '+'
		else 
			System.out.printf("%.1f%.1fi", comp.r, comp.i);
	}

	//add function
	public static Complexo add (Complexo comp1, Complexo comp2 ) {
		Complexo result = new Complexo ();

		result.r = comp1.r + comp2.r;	//sum of the real part
		result.i = comp1.i + comp2.i;	//sum of the im part
		return result;
	}

	//subtration function
	public static Complexo sub (Complexo comp1, Complexo comp2 ) {
		Complexo result = new Complexo ();

		result.r = comp1.r - comp2.r;	//sub of the real part
		result.i = comp1.i - comp2.i;	//sub of the im part
		return result;
	}

	//multiplication function
	public static Complexo mul (Complexo comp1, Complexo comp2 ) {
		Complexo result = new Complexo ();

		result.r = (comp1.r * comp2.r) - (comp1.i * comp2.i);	//mul of the real part
		result.i = (comp1.i + comp2.r) + (comp1.r * comp2.i);	//mul of the im part
		return result;
	}

	//division function
	public static Complexo div (Complexo comp1, Complexo comp2 ) {
		Complexo result = new Complexo ();

		result.r = ((comp1.r * comp2.r) - (comp1.i * comp2.i)) / (Math.pow(comp2.r,2) + Math.pow(comp2.i,2));	//div of the real part
		result.i = ((comp1.i + comp2.r) + (comp1.r * comp2.i)) / (Math.pow(comp2.r,2) + Math.pow(comp2.i,2));	//div of the im part
		return result;
	}
}

class Complexo {
	double r, i;
}