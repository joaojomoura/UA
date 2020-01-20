import static java.lang.System.*;

public class TestComplex {
  // Exemplo simples de utilização da class Complex
  public static void main(String[] args) {
    double n1 = Double.parseDouble(args[0]);
    double n2 = Double.parseDouble(args[1]);
    Complex a = new Complex(n1, n2);

    // Vamos usar métodos do objeto a
    out.println("(" + a.real() + " + " + a.imag() + "i)");
    out.println("  parte real = " + a.real());
    out.println("  parte imaginaria = " + a.imag());
    out.println("  modulo = " + a.abs());
    out.printf("  argumento =  %2.2f\n", a.arg());
  }

}
