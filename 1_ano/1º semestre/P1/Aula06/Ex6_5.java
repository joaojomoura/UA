//Aula 06 Ex_5

import java.util.Scanner;
import java.lang.Math;

public class Ex6_5{

    static Scanner sc = new Scanner (System.in);

    public static void main (String [] args){

    	//Read from user the size of the array
    	int num = 0;
    	System.out.print("Tamanho da seuqencia: ");
    	do{
    	 	num = read_num();
    	}while(num < 0);
    	
    	double a [] = new double [num]; //assign the array size

    	read_seq(a);
    	System.out.println(media(a,num));
    	System.out.println(desvio(media(a,num),num,a));
    	higher_than_media(a,media(a,num));

    }

    //Read the number given by user
     public static int read_num ()
    {
        int num;
        num = sc.nextInt();
      	return num;
    }

    //Read a sequence of numbers
    public static void read_seq(double a[])
    {
        int n = 0;
        double tmp;

        do{
            System.out.print("Valor real: ");
            tmp = sc.nextDouble();
            a[n] = tmp;
            n++;
        }while(n < a.length);
    }

    public static double media (double [] a, int num)
    {
    	double sum = 0, media;

    	for (double i : a)
    		sum = sum + i;
    	media = sum / num;

    	return media; 
    }

    public static double desvio (double media, int num, double [] a)
    {
    	double sum = 0, s;

    	for (double i : a)
    		sum = sum + Math.pow(i-media,2);
    	s = Math.sqrt(sum/num);

    	return s;
    }

    public static void higher_than_media (double [] a, double media)
    {
    	System.out.println("Valores maiores que a media: ");
    	for (double i : a)
    		if (i > media)
    			System.out.printf("%f ", i);
    	System.out.println();
    }
}