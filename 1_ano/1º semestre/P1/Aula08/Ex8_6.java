//Aula 8 Ex 6

import java.util.Scanner;

public class Ex8_6 {
	
	public static Scanner sc = new Scanner (System.in);

	public static void main (String [] args) {
		
		read_day();

	}

	public static Temperatura [] read_day () {

		Temperatura  [] t = new Temperatura [5];
		double amp_max = 0;
		int dia_max = 0;
				
		//Read the max and min tmp for each day and gives the amp max
		System.out.println("Introduza os valores das temperaturas em 5 dias:");
		for (int dia = 0; dia < 5; dia++) {
			t [dia] = read_temp (dia);
			if (amp_max < t[dia].amp) {
				amp_max = t[dia].amp;
				dia_max = dia;
			}
		}

		System.out.printf("A amplitude termica maxima foi de %.2f no dia %d.%n", amp_max, dia_max+1);
		return t;

	}

	//funtion to read max and min temp
	public static Temperatura read_temp (int dia) {

		Temperatura tmp = new Temperatura ();
		//read tmp min between -20 and 50
		do{
			System.out.printf("Temperatura min do dia %d: ", dia +1);
			tmp.temp_min = sc.nextDouble();		
		}while(tmp.temp_min < -20 || tmp.temp_max > 50);
		
		// read temp max only if the temp max is greater than temp min and is lower than 50
		do {
			System.out.printf("Temperatura max do dia %d: ", dia+1);
			tmp.temp_max = sc.nextDouble();
			if(tmp.temp_max < tmp.temp_min)
				System.out.println("Temperatura max tem de ser maior ou igual a Temperatura min!!");
		}while((tmp.temp_max < tmp.temp_min) || (tmp.temp_max > 50));
		
		tmp.amp = amp_t(tmp.temp_min, tmp.temp_max);

		return tmp;

	}

	//calculo da amplitude termica
	public static double amp_t (double t_min, double t_max) {
		return t_max - t_min;
	}

}

class Temperatura {
	double temp_min, temp_max, amp;
}