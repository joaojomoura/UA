import static java.lang.System.*;
import java.util.Scanner;

public class Ex1_6 {
    public static final Scanner in = new Scanner (System.in);

    public static void main (String []args) {
        int random = (int) (Math.random()*(100+1));
        int n = 0,count = 0;
        do {
            out.print("Numero: ");
            n = in.nextInt();
            count++;
            if(n < random)
                out.println("Numero abaixo do random");
            if (n > random)
                out.println("Numero acima do random");
            if(n == random)
                out.printf("Acertou no numero em %d tentativas%n",count);
        }while(n!=random);
    }
}