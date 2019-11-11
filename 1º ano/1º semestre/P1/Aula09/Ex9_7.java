//Aula 9 Ex 6 -> transforma a primeira letra em maiuscula
import java.util.Scanner;

public class Ex9_7 {


    public static Scanner sc = new Scanner(System.in); // criaçao da variavel de scanner

    public static void main(String[] args) {
        String frase = read_String();
        String [] t = capitalize_words(frase);
        for (int i = 0; i < t.length; i++)
            System.out.printf("%s ",t[i]);
        System.out.println();
    }

    public static String read_String () {
        String s = new String ();
        System.out.print("Ler frase: ");
        do {
            s = sc.nextLine();
        }while(s.isEmpty());
        return s;
    }

    // capitalize the first letter of the words
    public static String [] capitalize_words (String s) {

        String [] t = s.split(" ");	//split the sentence in an array of words
        for(int i = 0; i < t.length; i++) {
            t [i] = t[i].replace(t[i].charAt(0),Character.toUpperCase(t[i].charAt(0)));
        }
        return t;
    }
}