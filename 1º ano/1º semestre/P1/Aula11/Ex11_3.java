//ler lista de frases e colocar ao contrario

import java.util.Scanner;

public class Ex11_3 {
    static Scanner sc = new Scanner (System.in);
    public static void main (String [] args) {
        String [] sentence_list = new String [10];
        int n = store_sentence(sentence_list);
        for (int i = n - 2; i >= 0; i--)
            backwards(sentence_list[i]);
        
    }

    public static String  sentence (int n) {
        String frase =  new String ();
        do { 
            System.out.printf("Frase %d: ", n);
            frase = sc.nextLine();
        }while(frase.isEmpty());
        return frase;
    }

    public static int store_sentence (String [] sentence_list) {
        int count = 0;
        String frase;
        do {
            frase = sentence(count + 1);
            sentence_list [count] = frase;
            count++;
        }while(!frase.equalsIgnoreCase("fim") && count < sentence_list.length);
        return count;
    }

    public static void backwards(String frase) {
        char letra;
        for(int i = frase.length()-1; i >= 0; i--) {
            letra = frase.charAt(i);
            System.out.print(letra);
        }
        System.out.println();
    }

}