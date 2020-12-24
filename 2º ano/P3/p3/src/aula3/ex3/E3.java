/**
 * 
 */
package aula3.ex3;
import aula1.ex2.*;
import static java.lang.System.*;
/**
 * @author slowbro
 *
 */
public class E3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IllegalAccessException {
		
		try {
			Condutor c1 = new Condutor("Joao", 1, new Data(1, 1, 1), "A");
			Condutor c2 = new Condutor("Andre", 1, new Data(1, 1, 1), "B");
			Condutor c3 = new Condutor("Adriana", 1, new Data(1, 1, 1), "C");
			Condutor c4 = new Condutor("Paulo", 1, new Data(1, 1, 1), "D");
			
			out.print(c3.nome()+ " tem a carta " + c3.getCartaConducao() + " e pode conduzir ");
			c3.tipoDeCarta();
			out.println();
			
			Veiculo v1 = new Motociclo("A", 22, 1, 1, 1);
			Veiculo v2 = new Motociclo("B", 22, 1, 1, 1);
			Veiculo l1 = new Ligeiro("B", 22, 1, 1, 1);
			Veiculo l2 = new Ligeiro("B", 22, 1, 1, 2);
			Veiculo pm = new PesadoMercadorias("C", 22, 1, 1, 1);
			Veiculo pp = new PesadoPessoas("D", 22, 1, 1, 1);
			
			out.println("\nTestes dos condutores e veiculos:");
			out.println("Joao pode conduzir v1? -> " + v1.podeConduzir(c1)); // True
			out.println("Joao pode conduzir l2? -> " + l2.podeConduzir(c1)); // False
			out.println("Paulo pode conduzir pp? -> " + pp.podeConduzir(c4)); // True
			out.println("Paulo pode conduzir pm? -> " + pm.podeConduzir(c4)); // True
			out.println("Adriana pode conduzir pp? -> " + pp.podeConduzir(c3)); // False
			out.println("Andre pode conduzir l1? -> " + l1.podeConduzir(c2)); //True
		}
		catch (IllegalAccessException e){
			System.out.println("Não pode conduzir.");
		}
		catch (IllegalArgumentException e){
			System.out.println("Carta inválida.");
		}

	}

}
