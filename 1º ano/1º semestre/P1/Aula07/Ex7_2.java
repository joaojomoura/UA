//Aula 07 Ex_2

import java.util.Scanner;
import java.io.*;

public class Ex7_2{
    static Scanner sc = new Scanner (System.in);
    public static void main (String [] args) throws IOException{
        
        //int [] a = new int [100];
        //int num = read_num();
        //read_seq(a);
        //count(num,a);
        
        
        //Ex7 start
        String name_file = " ";
        int size;
        
        
        if (args.length == 1)
            name_file = args[0];
        else
            System.out.println("Erro!! A maneira certa é java Ex7_2 'filename'");
        
        size = read_file_numbers(name_file); // read the number of numbers of the file
        int [] a = new int [size];  		 //array size
        store_numbers_array(name_file,a);    //stores the numbers of the file into the array 
        									 //counts the number of times each number appeared
        
        
        
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
            if (a[i]==num)
               time ++;
        }
        if(time != 0)
        {
            if(time == 1)
                System.out.printf("%d ocorre %d vez\n",num,time);
            else
                System.out.printf("%d ocorre %d vezes\n",num,time);
        }
    }
    
    //read file given by user and counts the number of numbers in the file
    public static int read_file_numbers (String name) throws IOException
    {
        File fin = new File (name);
		Scanner read = new Scanner (fin);
        int count = 0, number = 0;
        
        //read file and counts how many numbers are there
        while (read.hasNextInt())
        {
            number = read.nextInt();
            count ++;
            if(count == 100)
                break;
        }
        read.close();
        return count;
    }
    
    //read the numbers of file and stores in the array
    public static void store_numbers_array (String name, int [] a) throws IOException
    {
        File fin = new File (name);
		Scanner read = new Scanner (fin);
        int number = 0, i = 0, max = 0, min = Integer.MAX_VALUE;;
        
        //read file
         while (read.hasNextInt())
        {
            
            number = read.nextInt();
            if(number > 0){ //stores number if is larger than 0
                    a[i] = number;
                    i++;
            
            	if (number < min)
                	min = number;
            	if (number > max)
                	max = number;
            
            }
           
        }
        
        read.close();
        for (int j = min; j <= max; j++)
            count(j,a);
    }
    
}
