import static java.lang.System.*;

public class TestComplex {
  // Exemplo simples de utilização da class Complex
  public static void main(String[] args) {
    Complex a = new Complex(5.0, 6.0);

    // Vamos usar métodos do objeto a
    out.println("(" + a.real() + " + " + a.imag() + "i)");
    out.println("  parte real = " + a.real());
    out.println("  parte imaginaria = " + a.imag());
    out.println("  modulo = " + a.abs());
    out.printf("  argumento =  %2.2f\n", a.arg());
  }

}
