//Aula 8 Ex 5

import java.util.Scanner;
import java.lang.Math;

public class Ex8_5 {

	static Scanner sc = new Scanner (System.in);

	public static void main (String [] args) {

		Person data = read_data();
		double coef = tas(data);
		print_data(data, coef);

	}

	public static Person read_data () {

		Person data = new Person ();
		char c = ' ';

		System.out.println("Preencha com os seus dados:");
		
		//Read String name
		do{
			System.out.print("Nome: ");
			data.name = sc.nextLine();
		}while (data.name.isEmpty());	//repeat if String is empty
		
		//Read char sex
		do{
			System.out.print("Sexo(M/F): ");
			data.sex = sc.nextLine().charAt(0);
			data.sex = Character.toUpperCase(data.sex); //puts any char to uppercase
		}while(data.sex != 'M' && data.sex != 'F');	//stops if char is M or F

		//Read weight
		do{
			System.out.print("Peso: ");
			data.weight = sc.nextDouble();
		}while(data.weight <= 0);

		//Read quantity of licor consumed
		do{
			System.out.print("Quantidade de alcool ingerida (ml): ");
			data.quantity = sc.nextInt();
		}while(data.quantity < 0);

		//Read teor
		do{
			System.out.print("Teor alcoolico da bebdida(% volume): ");
			data.teor = sc.nextDouble();
		}while(data.teor < 0 || data.teor > 100);

		//Read if the person was on jejum
		do{
			System.out.print("Consumiu em Jejum? (S/N) ");
			c = sc.next().charAt(0);
			c = Character.toUpperCase(c);
			if(c == 'S')
				data.jejum = true;
			else if(c == 'N')
				data.jejum = false; 
		}while(c != 'S' && c != 'N');

		return data;
	}

	//calculo da taxa de alcool no sangue
	public static double tas (Person data){

		final double den_a = 0.8;
		double coef = 0;
		//coef changes if its a female or male in jejum and if any of them aren't in jejum
		if (data.jejum && data.sex == 'M')
			coef = 0.7;
		else if (data.jejum && data.sex == 'F')
			coef = 0.6;
		else
			coef = 1.1;

		return ((0.8*data.quantity*(data.teor/100))/(data.weight*coef));
	}

	//print
	public static void print_data (Person data, double coef) {

		System.out.println("Informação da pessoa e a sua taxa de alcoolemia:");
		System.out.printf("Nome: %s%nSexo: %c%nPeso: %.1f%nQuantidade ingerida: %d%nTeor Alcoolico: %.1f%%%n", 
			data.name, data.sex, data.weight, data.quantity, data.teor);
		if(data.jejum)
			System.out.println("Consumiu em Jejum? Sim");
		else
			System.out.println("Consumiu em Jejum? Nao");
		System.out.printf("Taxa de alcoolemia: %.2f%n", coef);

	}
}

//Class with variables for a person
class Person {
	String name;
	char sex;
	double weight, teor;
	int quantity;
	boolean jejum;
}