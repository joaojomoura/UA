import static java.lang.System.*;
import java.util.Scanner;

public class Ex1_4 {
    public static final Scanner in = new Scanner (System.in);

    public static void main (String []args) {
        String line = new String();
        do {
            out.print("Frase: ");
            line = in.nextLine();
            line = dialect(line);
            out.println(line);
        } while(!line.isEmpty());
    }

    public static String dialect (String line) {
        line = line.replace('L', 'U');
        line = line.replace('l', 'u');
        line = line.replaceAll("R", "");
        line = line.replaceAll("r", "");
        return line;
    }
    
}