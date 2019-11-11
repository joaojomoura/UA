//Aula 9 Ex 6 -> troca l por u  e retira r
import java.util.Scanner;

public class Ex9_6 {


    public static Scanner sc = new Scanner(System.in); // criaçao da variavel de scanner

    public static void main(String[] args) {
        String frase = read_String();
        frase = frase.replace("l","u");
        frase = frase.replace("r","");
        frase = frase.replace("R","");
        frase = frase.replace("L","U");
        System.out.printf("%s%n",frase);
    }

    public static String read_String () {
        String s = new String ();
        System.out.print("Ler frase: ");
        do {
            s = sc.nextLine();
        }while(s.isEmpty());
        return s;
    }
}