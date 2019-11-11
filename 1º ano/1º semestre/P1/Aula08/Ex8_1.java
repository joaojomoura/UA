//Aula 8 Ex 1

import java.util.Scanner;

public class Ex8_1
{
	static final Scanner sc = new Scanner(System.in);

	public static void main (String [] args)
	{
		Hora inicio;  // tem de definir o novo tipo Hora!
	    Hora fim;
	    
	    inicio = new Hora();
	    inicio.h = 9;
	    inicio.m = 23;
	    inicio.s = 5;
	    
	    System.out.print("Começou às ");
	    printHora(inicio);  // crie esta função!
	    System.out.println(".");
	    System.out.println("Quando termina?");
	    fim = lerHora();  // crie esta função!
	    System.out.print("Início: ");
	    printHora(inicio);
	    System.out.print(" Fim: ");
	    printHora(fim);
	}

	//print the time given
	public static void printHora (Hora time)
	{
		System.out.printf("%02d:%02d:%02d", time.h, time.m, time.s);
	}

	//ask the user for the hour, min and seconds
	public static Hora lerHora()
	{
		Hora time = new Hora();

		do
		{
			System.out.print ("Horas? ");
			time.h = sc.nextInt();
		}while (time.h < 0 || time.h > 24);

		do
		{
			System.out.print ("Minutos? ");
			time.m = sc.nextInt();
		}while (time.m < 0 || time.m > 60);

		do
		{
			System.out.print ("Segundos? ");
			time.s = sc.nextInt();
		}while (time.s < 0 || time.s > 60);

		return time;
	}
}

//class hour with the int hour, minutes and seconds
class Hora
{
	int h, m, s;
}