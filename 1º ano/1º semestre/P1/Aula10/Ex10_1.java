//Aula 10 Ex_1  continuaçao do exercicio 7.3, juntar opçao de ordenaçao crescente, decrescente e pesquisa

import java.util.Scanner;
import java.io.*;

public class Ex10_1{
    static Scanner sc = new Scanner (System.in);
    public static void main (String [] args) throws IOException{

        int [] a = new int [50];
        int num , n = 0, n_file = 0;
        String file = new String();
        boolean is_sorted = false;

        //ask the user for the option he wants until 10 to quit
        do{
            menu(); //prints the menu
            num = read_num();   //read the number from user that is in the menu
            switch (num)
            {
                case 1 :
                    n = read_seq(a); //read the sequence from keyboard and returns the count of numbers
                    break;
                case 2 :
                    write_seq(a,n); //prints the sequence
                    break;
                case 3 :
                    max(a,n);   //max of the sequence
                    break;
                case 4 :
                    min(a,n);   //min of the sequence
                    break;
                case 5 :
                    media(a,n); //media of the sequence
                    break;
                case 6 :
                    //is it an even squence?
                    if(even_seq(a,n))
                        System.out.printf("É uma sequencia par!!\n\n");
                    else
                        System.out.printf("Não é uma sequencia par!!\n\n");
                    break;
                case 7 :
                    sc.nextLine();
                    System.out.print("Nome do ficheiro: ");
                    file = sc.nextLine();   //read the name of the file that has a sequence in there
                    n = store_numbers_array_from_file(file,a);  //stores the count numbers
                    break;
                case 8 :
                    n = add_to_seq(a,n); //adds more numbers to the sequence and stores the count of number
                    break;
                case 9 :
                    print_to_file(a,n); //prints the sequence to a a file
                case 10 :
                    is_sorted = selection_order(a,n); //sort min to max by selection sort
                    System.out.println("A lista esta ordenada");
                    break;
                case 11 :
                    is_sorted = bubble_sort(a,n);   //sort max to min by bubble sort
                    System.out.println("A lista esta ordenada");
                    break;
                case 12 :
                    System.out.print("Valor a pesquisar: ");
                    int num_search = sc.nextInt();
                    search_number(a,n,is_sorted,num_search);
                    break;
                case 13 :
                    System.out.println("O programa vai terminar..............");
                    break;
                default:
                    System.out.println("Numero inserido nao consta na lista!!");
                    System.out.println();
            }
        }while(num != 13);
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
        System.out.println("7 - ler uma sequência de números de um ficheiro de texto");
        System.out.println("8 - Adicionar números à sequência existente");
        System.out.println("9 - Gravar a sequência atual de números num ficheiro.");
        System.out.println("10 - Ordenar a sequência por ordem crescente utilizando ordenação sequencial");
        System.out.println("11 - Ordenar a sequência por ordem decrescente utilizando ordenação por flutuação");
        System.out.println("12 - Pesquisa de valor na sequência");
        System.out.println("13 - Terminar o programa");
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
                System.out.printf("%d ",a[i]);
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

    //read the numbers of file and stores in the array, then returns the numbers read
    public static int store_numbers_array_from_file (String name, int [] a) throws IOException
    {
        File fin = new File (name);
        Scanner read = new Scanner (fin);
        int number = 0, i = 0, count = 0;

        //read file
        while (read.hasNextInt())
        {

            number = read.nextInt();
            if(number > 0){ //stores number if is larger than 0
                a[i] = number;
                i++;
            }
            count++;
        }
        read.close();
        return count;
    }

    //add more numbers to the array
    public static int add_to_seq (int [] a, int count)
    {
        int tmp;
        do{
            System.out.print("Valor inteiro: ");
            tmp = sc.nextInt();
            if(tmp != 0){    //if the number is different than 0 it saves into array
                a[count] = tmp;
                count++;
            }
        }while(tmp != 0 && count < a.length);

        return count;
    }

    //print the array given by user or read from file to another file
    public static void print_to_file (int [] a, int n) throws IOException
    {
        String nameout = new String ();
        sc.nextLine();
        System.out.print("Nome do novo ficheiro: ");
        nameout = sc.nextLine();
        File fout  = new File (nameout);
        PrintWriter pw = new PrintWriter (fout);

        for (int i = 0; i < n; i++)
            pw.printf("%d%n", a[i]);

        pw.close();

    }

    //sort the array by seletion order
    public static boolean selection_order (int [] a, int n) {
        int tmp;                               //variavel temporaria
        for(int i = 0; i < n -1; i++) {       //fixa uma posiçao desde o inicio ate ao penultimo nº da lista
            for(int j = i + 1; j < n; j++) { //percorre a lista desde i + 1 ate ao fim da lista
                if(a[i] > a[j]) {           //se o elemento a[i] for maior que o a seguir a[j], troca
                    tmp = a [i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
        return true;
    }

    //sort the array by bubble sort
    public static boolean bubble_sort (int [] a, int n) {
        int tmp;
        int n_valores_ordenados = 0;    //numero de valores ordenados na lista
        boolean trocas;                 //variavel de trocas
        do {
            trocas = false;             //começamos por presumir que a lista esta ordenada

            //lemos a lista do primeiro elemento ate ao ultimo elemento nao ordenado
            for(int i = 0; i < n -1 - n_valores_ordenados; i++) {
                if(a[i] < a[i+1]) {
                    tmp = a[i+1];
                    a[i+1] = a[i];
                    a[i] = tmp;
                    trocas = true;  //houve trocas
                }
            }
            n_valores_ordenados ++; //aumenta a lista de valores ordenados
        }while(trocas);             //equanto houver trocas feitas o ciclo continua a ordenar

        return true;
    }

    //search the number on the list
    public static void search_number (int [] a, int n, boolean sort, int num) {

        //if the list is sorted use binary search
        int begin_b = 0, end_b = n - 1, middle_b;
        int number_found = -1;
        if (sort) {
            System.out.println("Como a sequencia esta ordenada usamos pesquisa binaria:");
            do {
                middle_b = (begin_b+end_b)/2;
                if(num > a[middle_b])
                    begin_b = middle_b + 1;
                else if (num < a[middle_b])
                    end_b = middle_b -1;
                else
                    number_found = middle_b + 1;
            }while(number_found == -1 && begin_b <= end_b);
            if(number_found != -1)
                System.out.printf("O valor %d esta na posiçao %d da lista%n", num, number_found);
            else
                System.out.println("O valor nao esta na lista");
        }
        // else use sequencial sort
        else {  
            System.out.println("Como a sequencia não está ordenada usamos pesquisa sequencial:");
            int m = 0;
            int pos = -1;
            do {
                if(a[m++] == num)
                    pos = m;
            }while (pos == -1 && m < n);

            if(pos != -1)
                System.out.printf("O valor %d esta na posiçao %d da lista%n", num, pos);
            else
                System.out.println("O valor nao esta na lista");
        }
    }
}
