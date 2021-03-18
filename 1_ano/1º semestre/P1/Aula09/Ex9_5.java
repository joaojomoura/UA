//Aula 9 Ex 5 -> converter numero decimal para bases entre 2 e 10
import java.util.Scanner;

public class Ex9_5 {


    public static Scanner sc = new Scanner (System.in); // criaçao da variavel de scanner

    public static void main (String [] args) {
        int num = read_num();
        String n = convert_to_string(num);
        String [] base = base_number(num);
        print(base,n);

    }

    //ler numero dado pelo utilizador
    public static int read_num() {
        int n;
        System.out.println("Converter numero decimal em bases de 2 ate 10");
        System.out.print("Numero inteiro: ");
        do {
            n = sc.nextInt();
        } while (n < 0);

        return n;
    }

    //converter numero int para String
    public static String convert_to_string (int num) {
        String s = String.valueOf(num);
        return s;
    }

    //converter para qualquer base e devolve um array de strings com as varias bases
    public static String [] base_number (int num) {
        String [] s = new String [9];
        int base = 0, i = 2;
        for (int j = 0; j < s.length; j++) {
            s[j] = new String ();
            int n = num;
            do {
                base = n % i;
                n /= i;
                s[j] = s[j].concat(convert_to_string(base));
            } while (n!= 0);
            i++;
        }
        return s;
    }

    //troca a ordem da String
    public static String troca_ordem (String s) {
        String a = new String ();
        char c;
        for (int i = 0;i < s.length(); i++) {
            c = s.charAt(i);
            a = c + a;
        }
        return a;
    }

    //imprimir
    public static void print (String [] s, String a) {
        for (int i = 0, j = 2; i < s.length; i++) {
            System.out.printf("numToBase(%s,%d) devolve %s%n", a, j, troca_ordem(s[i]));
            j++;
        }
    }
}
