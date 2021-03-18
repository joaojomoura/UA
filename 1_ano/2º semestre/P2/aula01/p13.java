import static java.lang.System.*;
import java.util.Scanner;

public class p13 {
  public static final Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    int n;
    while (true) {
      out.print("N? ");
      n = in.nextInt();
      if (n > 0) break;
      err.println("ERROR: invalid number!");
    }

    String verb = isPrime(n)? "is" : "is not";
    out.printf("Number %d %s prime\n", n, verb);
  }

  public static boolean isPrime(int n) {
    if(n == 1)
      return false;
    if(n == 2)
      return true;
    if(n != 2 && n % 2 == 0)
      return false;
    for(int i = 2; i <= n / 2; i++) {
      if(n % i == 0) {
        return false;
      }
    }
    return true;

  }
}
