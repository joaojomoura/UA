/**
 * 
 */
package aula12.ex3;

import java.io.IOException;

/**
 * @author João Moura
 *
 */
public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		

		Ementa ementa = new Ementa("Especial Caloiro", "Snack da UA");
		Prato[] pratos = new Prato[10];

		for (int i=0; i < pratos.length; i++)
		{
			pratos[i] = randPrato(i);
			int cnt = 0;
			while (cnt <2)
			{ // Adicionar 2 Ingredientes a cada Prato
				Ingrediente aux = randAlimento();
				if (pratos[i].addIngrediente(aux))
					cnt++;
				else
					System.out.println("ERRO: Não é possivel adicionar '" + aux + "' ao -> " + pratos[i]);
			}
			ementa.addPrato(pratos[i], DiaSemana.rand());
			// Dia Aleatório
		}
		System.out.println("\n" + ementa);
		
		
	}
	
	// Retorna um Alimento Aleatoriamente
	public static Ingrediente randAlimento() 
	{
		switch ((int) (Math.random() * 4)) 
		{
			default:
	
			case 0:
				return new Carne(VariedadeCarne.FRANGO, 22.3, 345.3, 300);
			case 1:
				return new Peixe(Tipo.CONGELADO, 31.3, 25.3, 200);
			case 2:
				return new Legume("Couve Flor", 21.3, 22.4, 150);
			case 3:
				return new Cereal("Milho", 19.3, 32.4, 110);
		}
	}
	
	public static Prato randPrato(int i) 
	{
		switch ((int) (Math.random() * 3)) 
		{
			default:
			case 0:
				return new Prato("Prato N." + i);
			case 1:
				return new PratoVegetariano("Prato N." + i + " (Vegetariano)");
			case 2:
				return new PratoDieta("Prato N." + i + " (Dieta)", 90.8);
		}
	}
	
	
}
