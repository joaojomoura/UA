//Aula 06 Ex_2

import java.util.Scanner;

public class Ex6_2{
    static Scanner sc = new Scanner (System.in);
    public static void main (String [] args){
        
        int [] a = new int [100];
        int num = read_num();
        read_seq(a);
        count(num,a);
        
    }
    
    //Read the number given by user
    public static int read_num ()
    {
        int num;
        do
        {
            System.out.print("Numero: ");
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
            if (a[i] == num)
                time ++;
        }
        System.out.print(time);
    }
}
