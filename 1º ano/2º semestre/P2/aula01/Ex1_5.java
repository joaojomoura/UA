import static java.lang.System.*;
import java.util.Scanner;

public class Ex1_5 {
    public static final Scanner in = new Scanner (System.in);

    public static void main (String []args) {
        int [] number = new int [100];
        int n, count = 0, soma = 0;
        double media;
        do {
            out.print("Numero: ");
            n = in.nextInt();
            if(n != 0){
                number[count] = n;
                count++;
            }
        }while(n != 0);
        if(count == 0)
            out.println("Soma = 0 e Media não pode ser calculada");
        for (int i = 0; i < number.length;i++) 
            soma  += number[i];
        media =(double) soma/count; 
        out.printf("Soma = %d, Media = %.2f%n",soma,media);
        
    }
}