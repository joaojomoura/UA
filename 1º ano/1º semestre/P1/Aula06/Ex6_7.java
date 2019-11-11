//Aula 06 Ex_7

import java.util.Scanner;
import java.lang.Math;

public class Ex6_7{
    static Scanner sc = new Scanner (System.in);
    public static void main (String [] args){
        
        
        int num = read_num();
        //int [] a = new int [num];
        //read_seq(a);
        //count(num,a);
        random_int(2,5,num);
        
    }
    
    //Read the number given by user
    public static int read_num ()
    {
        int num;
        do
        {
            System.out.print("Tamanho do array: ");
            num = sc.nextInt();
        }while (num < 0);
        
        return num;
    }
    
    //Read a sequence of numbers
    public static void read_seq(int a[])
    {
        int n = 0, tmp;
        do{
            System.out.print("Valor inteiro: ");
            tmp = sc.nextInt();
            if(tmp > 0){    //if the number is larger than 0 it saves into array
                a[n] = tmp;
                n++;
            }
        }while(tmp > 0 && n < a.length); 
    }
    
    //counter of the number of times that the number given by user shows on the sequence
    public static void count (int num, int [] a)
    {
        int time = 0;
        for (int i = 0; i < a.length; i++)
        {
            if (a[i]==num)
               time ++;
        }
        if(time == 1)
            System.out.printf("%d ocorre %d vez\n",num,time);
        else
            System.out.printf("%d ocorre %d vezes\n",num,time);
    }

    //funtion to create an array of random numbers
    public static void random_int (int xi, int xf, int num_size) 
    {
        int a [] = new int [num_size];
        int range = xf - xi + 1;
        

        for (int i = 0; i < a.length; i++)
        {
            int random = (int) (Math.random()*range)+xi;
            System.out.printf("%d, ",random);
            a[i] = random;
        }
        System.out.println();

        for (int i = xi; i <= xf; i++)
        {
            count(i,a);
        }
    }
}