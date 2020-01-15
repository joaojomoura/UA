import java.util.*;
import static java.lang.System.*;

public class Ex1_1 {
    static final Scanner sc = new Scanner (System.in);
    public static void main (String [] args) {
        double num1, num2, res;
        String op = new String();

        num1 = sc.nextDouble();
        op = sc.next();
        num2 = sc.nextDouble();
        switch(op) {
            case "+":
                res = num1 + num2;
                out.println(res);
                break;
            case "-":
                res = num1 - num2;
                out.println(res);
                break;
            case "*":
                res = num1 * num2;
                out.println(res);
                break;
            case "/":
                res = num1 / num2;
                out.println(res);
                break;
            default:
                err.println("Operador invalido");
                    
        }
    }
}