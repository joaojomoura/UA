/**
 * 
 */
package aula5.ex2;
import aula5.ex1.*;

/**
 * @author João Moura
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Veiculo[] listaVeiculo = new Veiculo[] {
				new Automovel("BMW", 2007, 4, "Vermelho", 3500, "11-AA-12", 5.9, "Gasolina"),
				new Mota("Harley Davidson", 2020, 2, "Azul Metalico", 4000, "55-HB-56", 4.5, "Gasolina"),
				new Bicicleta("Nike", 2016, 2, "Verde"),
				new CarroPolicia("Ford", 2017, 4, "Azul-Branco", 3700, "11-BD-12", 5.9, "Gasoleo", Tipo.GNR, 124),
				new MotaPolicia("Honda", 2005, 2, "Preto", 4000, "55-CE-69", 4.5, "Gasolina", Tipo.PJ, 255),
				new BicicletaPolicia("Nike", 2018, 2, "Amarelo", Tipo.PSP, 237)
			};
			
			System.out.println("\nLista de veiculos pela ordem inserida:\n");
			for(Veiculo v : listaVeiculo)
				System.out.println(v);
			
			System.out.println("\n\nLista de veiculos ordenados por ano:\n");
			UtilCompare.sortArray(listaVeiculo);
			for(Veiculo v : listaVeiculo)
				System.out.println(v);

	}

}
