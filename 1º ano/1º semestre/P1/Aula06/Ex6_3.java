//Aula 06 Ex_3

import java.util.Scanner;

public class Ex6_3{

    static Scanner sc = new Scanner (System.in);

    public static void main (String [] args){
        int [] a = new int [50];
        int num , n = 0 ;
        
        //ask the user for the option he wants until 10 to quit
        do{
            menu();
            num = read_num();
            switch (num)
            {
            	case 1 :
            		n = read_seq(a);
            		break;
            	case 2 :
            		write_seq(a,n);
            		break;
            	case 3 :
            		max(a,n);
            		break;
            	case 4 :
            		min(a,n);
            		break;
            	case 5 :
            		media(a,n);
            		break;
            	case 6 :
            		if(even_seq(a,n))
            			System.out.printf("É uma sequencia par!!\n\n");
            		else 
            			System.out.printf("Não é uma sequencia par!!\n\n");
            		break;
            	case 10 :
            		break;
            	default:
            		System.out.println("Numero inserido nao consta na lista!!");
            		System.out.println();
            }
        }while(num != 10);
    }
    
    //prints the menu
    public static void menu ()
    {
        System.out.println("Análise de uma sequência de números inteiros");
        System.out.println("1 - Ler a sequência");
        System.out.println("2 - Escrever a sequência");
        System.out.println("3 - Calcular o máximo da sequência");
        System.out.println("4 - Calcular o mínimo da sequência");
        System.out.println("5 - Calcular a média da sequência");
        System.out.println("6 - Detetar se é uma sequência só constituída por números pares");
        System.out.println("10 - Terminar o programa");
        System.out.print("Opção ->");
    }
    
    //Read the number given by user
    public static int read_num ()
    {
        int num;
        num = sc.nextInt();
      	return num;
    }
    
    
    //Read a sequence of numbers
    public static int read_seq(int a[])
    {
        int n = 0, tmp;
        do{
            System.out.print("Valor inteiro: ");
            tmp = sc.nextInt();
            if(tmp != 0){    //if the number is different than 0 it saves into array
                a[n] = tmp;
                n++;
            }
        }while(tmp != 0 && n < a.length);

        return n; 
    }

    //Prints the array
    public static void write_seq (int [] a, int n)
    {
    	if(a[0] != 0)
    		for(int i = 0; i < n; i++)
    			System.out.print(a[i]);
    	else
    		System.out.println("Lista vazia!!");
    	System.out.println();
    	System.out.println();
    }

    //Check which is the highest number
    public static void max (int [] a, int n)
    {
    	int max = 0;

    	for (int i = 0; i < n; i++)
    		if (max < a[i])
    			max = a[i];
    	System.out.println("O maior numero é: " + max);
    	System.out.println();
    
    }

    //Check which is the lowest number
    public static void min (int [] a, int n)
    {
    	int min = Integer.MAX_VALUE; //max value of an integer

    	for (int i = 0; i < n; i++)
    		if (min > a[i])
    			min = a[i];
    	System.out.println("O menor numero é: " + min);
    	System.out.println();
    }


    // funtion to figure out the media
    public static void media (int [] a, int n)
    {
    	int sum = 0;
    	double media;

    	for (int i = 0; i < n; i++)
    		sum = sum + a[i];

    	media = sum / n;


    	System.out.printf("A media é %f\n\n",media);
    }

    //check if the seq is even or not
    public static boolean even_seq (int [] a, int n)
    {
    	boolean even = false;
    	
    	

    	for (int i = 1; i < n; i++)
    	{
    		if(a[i] % 2 != 0)
    			return false;
    		else 
    			even = true;
    	}

    	return even;

    }
}
