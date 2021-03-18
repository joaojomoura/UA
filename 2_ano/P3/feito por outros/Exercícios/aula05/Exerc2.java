package aula05;

public class Exerc2 {
	public static void main(String[] args) {
		Veiculo[] listaVeiculo = new Veiculo[] {
			new Automovel(1991, "AA-19-91", "Vermelho", 4, 3456, 200, 10, 5, 25),
			new Moto(1979, "MM-19-79", "Laranja", 2, 2345, 150, 5, 10, 30),
			new Bicicleta(1950, "BB-19-50", "Amarelo", 2, 1234, 60, 3, 0, 0),
			new CarroPolicia(2010, "CP-20-10", "Azul", 4, 3456, 220, 15, 4, 20, Tipo.GNR),
			new MotoPolicia(2009, "MP-20-09", "Preto", 2, 2345, 170, 10, 9, 25, Tipo.PJ),
			new BicicletaPolicia(2008, "BP-20-08", "Verde", 2, 1234, 70, 5, 0, 0, Tipo.PSP)
		};
		
		System.out.println("\nLista de veículos pela ordem inserida:\n");
		for (int i=0; i<listaVeiculo.length; i++) {
			System.out.println(listaVeiculo[i]);
		}
		
		UtilCompare.sortArray(listaVeiculo);
		System.out.println("\nLista de veículos ordenados por ano:\n");
		for (int i=0; i<listaVeiculo.length; i++) {
			System.out.println(listaVeiculo[i]);
		}
	}
}
