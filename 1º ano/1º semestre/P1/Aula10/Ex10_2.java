//Exercicio 10.2 TOTOLOTO

import java.util.Scanner;
import java.lang.Math;

public class Ex10_2 {
    static Scanner sc = new Scanner (System.in);

    public static void main (String [] args) {
        //numeros do totoloto
        int [] totoloto = new int [49];
        for (int i = 0; i < totoloto.length; i++)
            totoloto[i] = i + 1;
        //random key gerada e sorteada
        int [] random_key = gerar_chave();
        sort (random_key);
        mostraChave(random_key,totoloto);
    }

    //cria uma chave de totoloto
    public static int [] gerar_chave () {
        int [] array = new int [6]; //new array to store key
        int max = 49;
        int min = 1;
        int range = max - min + 1;
        int n = 0;

        //if the random number does not repeat it stores to array
        do {
            int rand = (int)(Math.random() * range) + min;
            if(pertenceChave(array, rand))  {
                array [n] = rand;
                n++;
            }
        }while(n < array.length);
        return  array;
    }

    //funçao para pesquisar numeros no array
    public static boolean pertenceChave (int [] a, int n) {

        int m = 0;
        int pos = -1;
        do {
            if(a[m++] == n)
                pos = m;
        }while (pos == -1 && m < a.length);
        if(pos == -1)
            return true;
        return false;
    }

    //funçao para ordenar array
    public static void sort (int [] a) {
        int tmp;
        int n_valores_ordenados = 0;    //numero de valores ordenados na lista
        boolean trocas;                 //variavel de trocas
        do {
            trocas = false;             //começamos por presumir que a lista esta ordenada

            //lemos a lista do primeiro elemento ate ao ultimo elemento nao ordenado
            for(int i = 0; i < a.length -1 - n_valores_ordenados; i++) {
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

    public static void mostraChave (int [] a, int [] totoloto) {

        //impressao da chave do totoloto
        System.out.println("     Aposta do totoloto");
        System.out.print("Chave:");
        for(int i = 0; i < a.length; i++)
            System.out.printf(" %d,", a[i]);
        System.out.printf("%n%n%n");

        //impressao dos numeros do totoloto
        int n = 0;
        int m = 0;

        //verifica se os numeros da chave estao no totoloto
        do {
            if(pertenceChave(totoloto, a[m]) == false)
                totoloto[a[m] - 1] = 0;
            m++;
        } while(m < a.length);

        //imprime o totoloto com os numeros da chave com X
        for(int i = 0; i < 7; i++) {
            for(int j = 0; j < 7; j++) {

                if(totoloto[n] == 0)
                    System.out.print(" X ");
                else
                    System.out.printf(" %2d", totoloto[n]);
                n++;


            }
            System.out.println();
        }

    }
}