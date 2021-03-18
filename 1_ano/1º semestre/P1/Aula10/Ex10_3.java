//Ex10_3, ler de um ficheiro os pH validos

import java.util.Scanner;
import java.io.*;

public class Ex10_3 {

    public static Scanner sc = new Scanner (System.in);

    public static void main (String [] args) throws IOException {
        double media = 0;
        int num = 0;

        int size_array = 0;
        String file_name = file_name();
        size_array = size_array(file_name);
        double [] ph_array = new double [size_array];



        //ask the user for the option he wants until 10 to quit
        do {


            menu(); //prints the menu
            num = read_num();   //read the number from user that is in the menu
            switch (num) {
                case 1:
                    ph_array = ph_array_numbers(file_name, ph_array,size_array);
                    break;
                case 2:
                    print(ph_array, size_array);
                    break;
                case 3:
                    media = media(ph_array, size_array);
                    break;
                case 4:
                    acid_basic(ph_array, size_array);
                    break;
                case 5:
                    ph_larger_media(ph_array, size_array,media);
                    break;
                case 6:
                    sort(ph_array, size_array);
                    break;
                case 7:
                    System.out.println("O programa vai terminar..............");
                    break;
                default:
                    System.out.println("Numero inserido nao consta na lista!!");
                    System.out.println();
            }
        }while (num != 7);

    }

    //Read the number given by user
    public static int read_num ()
    {
        int num;
        num = sc.nextInt();
        return num;
    }

    public static void menu () {
        System.out.println("Analisador de pH");
        System.out.println("1 - Ler valores de pH de um ficheiro");
        System.out.println("2 - Escrever valores de pH no terminal");
        System.out.println("3 - Calcular o pH médio das amostras");
        System.out.println("4 - Calcular o número de amostras ácidas (< 7) e básicas (> 7)");
        System.out.println("5 - Calcular o número de amostras de pH superior à média");
        System.out.println("6 - Escrever valores de pH no terminal ordenados de modo crescente");
        System.out.println("7 - Terminar o programa");
        System.out.print("Opçao -> ");

    }

    //file name given by user
    public static String file_name () {
        System.out.print("Nome do ficheiro: ");
        String file = sc.nextLine();   //read the name of the file that has a sequence in there
        return file;
    }

    //discover the correct size for the array
    public static int size_array (String name) throws IOException {
        File fin = new File (name);
        Scanner read = new Scanner (fin);
        int count = 0;
        double number;

        //read file
        while (read.hasNextDouble())
        {

            number = read.nextDouble();
            if(number >= 0 && number <= 14){ //stores number if is larger than 0 and lower than 14
                count++;
            }
        }
        read.close();
        return count;
    }

    //stores the numbers of the file on an array
    public static double [] ph_array_numbers (String name, double [] a, int n) throws IOException{
        a = new double [n];
        File fin = new File (name);
        Scanner read = new Scanner (fin);
        int i = 0;
        double number;

        //read file
        while (read.hasNextDouble())
        {

            number = read.nextDouble();
            if(number >= 0 && number <= 14){ //stores number if is larger than 0 and lower than 14
                a[i++] = number;
            }
        }
        read.close();
        return a;

    }

    //MEDIA
    public static double media (double [] a, int n) {
        double sum = 0, media;
        for(int i = 0; i < n; i++) {
            sum += a[i];
        }
        media = (double) sum / n;
        System.out.printf("A media do ph e : %2.2f %n",media);
        return media;
    }

    //write the array on terminal
    public static void print (double [] a, int n) {

        System.out.println("Valores do pH");
        for(int i = 0; i < n; i++) {
            System.out.printf("%.2f ", a[i]);
        }
        System.out.println();
    }

    //verify which ph is basic or acid
    public static void acid_basic (double [] a, int n) {
        int count_a = 0, count_b = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] < 7)    //acid ph counter
                count_a++;
            if (a[i] > 7)   //basic ph counter
                count_b++;
        }
        System.out.printf("Existem %2d amostras acidas e %2d amostras basicas.%n", count_a, count_b);
    }

    //counts the number of ph larger than media
    public static void ph_larger_media (double [] a, int n, double media) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] > media)
                count ++;
        }

        System.out.printf("Existem %2d amostras superiores a media.%n", count);

    }

    //sort the array
    public static void sort (double [] a, int n) {
        double tmp;
        int n_valores_ordenados = 0;    //numero de valores ordenados na lista
        boolean trocas;                 //variavel de trocas
        do {
            trocas = false;             //começamos por presumir que a lista esta ordenada

            //lemos a lista do primeiro elemento ate ao ultimo elemento nao ordenado
            for(int i = 0; i < n -1 - n_valores_ordenados; i++) {
                if(a[i] > a[i+1]) {
                    tmp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = tmp;
                    trocas = true;  //houve trocas
                }
            }
            n_valores_ordenados ++; //aumenta a lista de valores ordenados
        }while(trocas);             //equanto houver trocas feitas o ciclo continua a ordenar
    }
}