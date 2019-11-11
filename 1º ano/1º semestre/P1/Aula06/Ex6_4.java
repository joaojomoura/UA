//Aula 06 Ex_4

import java.util.Scanner;

public class Ex6_4{

    static Scanner sc = new Scanner (System.in);

    public static void main (String [] args){

    	//variables
    	int num_notas = 0, n;
    	int [] a = new int [50];

    	System.out.print("Numero de notas a processar: ");
    	do{
    		num_notas = read_num();
    	}while(num_notas <= 0);

    	n = read_seq(a,num_notas);
    	assign(a,n);

	}
    //Read the number given by user
    public static int read_num ()
    {
        int num;
        num = sc.nextInt();
      	return num;
    }

    //Read a sequence of numbers
    public static int read_seq(int a[], int num_notas)
    {
        int n = 0, tmp;
        do{
            System.out.print("Valor inteiro (0 a 20): ");
            tmp = read_num();
            if(tmp >= 0 && tmp <= 20){    //if the number is between 0 and 20 it saves into array
                a[n] = tmp;
                n++;
            }
        }while(n < num_notas);

        return n; 
    }

    //
    public static void assign (int [] a, int n)
    {
    	System.out.println("Histograma de notas");
    	System.out.println("-------------------------------------------------------");

    	for (int i = 20; i >= 0; i--)
    		{
    			System.out.printf("%2d | ",i);
    			for (int j = 0; j < n; j++)
    			{
    				if(i == a[j])
    					System.out.print("*");
    			}
    		System.out.println();
    		}

    }




}