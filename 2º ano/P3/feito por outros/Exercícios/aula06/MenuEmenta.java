package aula06;
import java.util.Scanner;

public class MenuEmenta {
	private static Scanner in = new Scanner(System.in);
	private static Alimento[] alimentos = new Alimento[100];
	private static Prato[] pratos = new Prato[100];
	private static Prato seleccionado;
	private static int nAlimentos = 0;
	private static int nPratos = 0;

	public static void main(String[] args) {
		menuPrincipal();
	}
	
	public static void menuPrincipal() {
		System.out.println("\nSeleccione um dos menus existentes: ");
		System.out.println("1. Ingrediente");
		System.out.println("2. Prato");
		System.out.println("3. Ementa");
		System.out.println("4. Sair");
		int op = in.nextInt();
		
		while (op<1 || op>4) {
			System.err.println("\nERRO: Opção inválida! Escolha uma opção de 1 a 4");
			op = in.nextInt();
		}
		
		switch (op) {
			case 1: { menuIngredientes(); break; }
			case 2: { menuPratos(); break; }
			case 3: { menuEmentas(); break; }
			case 4: { System.exit(0); }
		}
	}
	
	public static void menuIngredientes() {
		System.out.println("\nSeleccione uma das opções existentes: ");
		System.out.println("1. Adicionar Carne");
		System.out.println("2. Adicionar Peixe");
		System.out.println("3. Adicionar Cereal");
		System.out.println("4. Adicionar Legume");
		System.out.println("5. Menu anterior");
		int op = in.nextInt();
		
		while (op<1 || op>5) {
			System.err.println("\nERRO: Opção inválida! Escolha uma opção de 1 a 5");
			op = in.nextInt();
		}
		
		switch (op) {
			case 1: { adicionaCarne(); break; }
			case 2: { adicionaPeixe(); break; }
			case 3: { adicionaCereal(); break; }
			case 4: { adicionaLegume(); break; }
			case 5: { menuPrincipal(); break; }
		}
	}
	
	public static void adicionaCarne() {
		System.out.println("\nVariedade: "); in.next();
		String va = in.nextLine();
		System.out.println("Proteinas: ");
		double pr = in.nextDouble();
		System.out.println("Calorias: ");
		double ca = in.nextDouble();
		System.out.println("Peso: ");
		double pe = in.nextDouble();
		
		if (va.equals("vaca")) {
			alimentos[nAlimentos] = new Carne(VariedadeCarne.vaca, pr, ca, pe);
		}
		else if (va.equals("porco")) {
			alimentos[nAlimentos] = new Carne(VariedadeCarne.porco, pr, ca, pe);
		}
		else if (va.equals("peru")) {
			alimentos[nAlimentos] = new Carne(VariedadeCarne.peru, pr, ca, pe);
		}
		else if (va.equals("frango")) {
			alimentos[nAlimentos] = new Carne(VariedadeCarne.frango, pr, ca, pe);
		}
		else if (va.equals("outra")) {
			alimentos[nAlimentos] = new Carne(VariedadeCarne.outra, pr, ca, pe);
		}
		nAlimentos++;
		menuIngredientes();
	}
	
	public static void adicionaPeixe() {
		System.out.println("\nTipo: "); in.next();
		String ti = in.nextLine();
		System.out.println("Proteinas: ");
		double pr = in.nextDouble();
		System.out.println("Calorias: ");
		double ca = in.nextDouble();
		System.out.println("Peso: ");
		double pe = in.nextDouble();
		
		if (ti.equals("congelado")) {
			alimentos[nAlimentos] = new Peixe(TipoPeixe.congelado, pr, ca, pe);
		}
		else if (ti.equals("fresco")) {
			alimentos[nAlimentos] = new Peixe(TipoPeixe.fresco, pr, ca, pe);
		}
		nAlimentos++;
		menuIngredientes();
	}
	
	public static void adicionaCereal() {
		System.out.println("\nNome: "); in.next();
		String no = in.nextLine();
		System.out.println("Proteinas: ");
		double pr = in.nextDouble();
		System.out.println("Calorias: ");
		double ca = in.nextDouble();
		System.out.println("Peso: ");
		double pe = in.nextDouble();
		
		alimentos[nAlimentos] = new Cereal(no, pr, ca, pe);
		nAlimentos++;
		menuIngredientes();
	}
	
	public static void adicionaLegume() {
		System.out.println("\nNome: "); in.next();
		String no = in.nextLine();
		System.out.println("Proteinas: ");
		double pr = in.nextDouble();
		System.out.println("Calorias: ");
		double ca = in.nextDouble();
		System.out.println("Peso: ");
		double pe = in.nextDouble();
		
		alimentos[nAlimentos] = new Legume(no, pr, ca, pe);
		nAlimentos++;
		menuIngredientes();
	}
	
	public static void menuPratos() {
		System.out.println("\nSeleccione uma das opções existentes: ");
		System.out.println("1. Cria Prato");
		System.out.println("2. Apaga Prato");
		System.out.println("3. Selecciona Prato");
		System.out.println("4. Adiciona Ingrediente");
		System.out.println("5. Remove Ingrediente");
		System.out.println("6. Menu Anterior");
		int op = in.nextInt();
		
		while (op<1 || op>6) {
			System.err.println("\nERRO: Opção inválida! Escolha uma opção de 1 a 6");
			op = in.nextInt();
		}
		
		switch (op) {
			case 1: { criaPrato(); break; }
			case 2: { apagaPrato(); break; }
			case 3: { seleccionaPrato(); break; }
			case 4: { adicionaIngrediente(); break; }
			case 5: { removeIngrediente(); break; }
			case 6: { menuPrincipal(); }
		}
	}
	
	public static void criaPrato() {
		System.out.println("\nNome do prato: "); in.next();
		String nome = in.nextLine();
		pratos[nPratos] = new Prato(nome);
		nPratos++;
		menuPratos();
	}
	
	public static void apagaPrato() {
		System.out.println("\nNome do prato a apagar: "); in.next();
		String nome = in.nextLine();
		for (int i=0; i<nPratos; i++) {
			if (nome == pratos[i].getNome()) {
				for (int j = i+1; j<nPratos; j++) {
					pratos[i]=pratos[j];
				}
				pratos[nPratos]=null;
				nPratos--;
				break;
			}
		}
		menuPratos();
	}
	
	public static void seleccionaPrato() {
		System.out.println("\nNome do prato a seleccionar: "); in.next();
		String nome = in.nextLine();
		for (int i=0; i<nPratos; i++) {
			if (nome == pratos[i].getNome()) {
				seleccionado = pratos[i];
				break;
			}
		}
		menuPratos();
	}
	
	public static void adicionaIngrediente() {
		System.out.println("\nSeleccione o tipo de ingrediente: ");
		System.out.println("1. Carne");
		System.out.println("2. Peixe");
		System.out.println("3. Cereal");
		System.out.println("4. Legume");
		int op = in.nextInt();
		
		while (op<1 || op>4) {
			System.err.println("\nERRO: Opção inválida! Seleccione uma opção de 1 a 4");
			op = in.nextInt();
		}
		
		switch (op) {
			case 1: {
				System.out.println("\nVariedade da carne: "); in.next();
				String ingrediente = in.nextLine();
				VariedadeCarne variedade = VariedadeCarne.outra;
				if (ingrediente.equals("vaca")) {
					variedade = VariedadeCarne.vaca;
				}
				else if (ingrediente.equals("porco")) {
					variedade = VariedadeCarne.porco;
				}
				else if (ingrediente.equals("peru")) {
					variedade = VariedadeCarne.peru;
				}
				else if (ingrediente.equals("frango")) {
					variedade = VariedadeCarne.frango;
				}
				else if (ingrediente.equals("outra")) {
					variedade = VariedadeCarne.outra;
				}
				for (int i=0; i<nAlimentos; i++) {
					Carne c = (Carne) alimentos[i];
					if (variedade == c.getVariedade()) {
						seleccionado.addIngrediente(c);
						break;
					}
				}
				menuPratos(); break;
			}
			case 2: {
				System.out.println("\nTipo do peixe: "); in.next();
				String ingrediente = in.nextLine();
				TipoPeixe tipo = TipoPeixe.congelado;
				if (ingrediente.equals("congelado")) {
					tipo = TipoPeixe.congelado;
				}
				else if (ingrediente.equals("fresco")) {
					tipo = TipoPeixe.fresco;
				}
				for (int i=0; i<nAlimentos; i++) {
					Peixe p = (Peixe) alimentos[i];
					if (tipo == p.getTipo()) {
						seleccionado.addIngrediente(p);
						break;
					}
				}
				menuPratos(); break; 
			} 
			case 3: {
				System.out.println("\nNome do cereal: "); in.next();
				String ingrediente = in.nextLine();
				for (int i=0; i<nAlimentos; i++) {
					Cereal c = (Cereal) alimentos[i];
					if (ingrediente == c.getNome()) {
						seleccionado.addIngrediente(c);
						break;
					}
				}
				menuPratos(); break; 
			}
			case 4: {
				System.out.println("\nNome do legume: "); in.next();
				String ingrediente = in.nextLine();
				for (int i=0; i<nAlimentos; i++) {
					Legume l = (Legume) alimentos[i];
					if (ingrediente == l.getNome()) {
						seleccionado.addIngrediente(l);
						break;
					}
				}
				menuPratos(); break; 
			}
		}
		
		menuPratos();
	}
	
	public static void removeIngrediente() {
		
	}
	
	public static void menuEmentas() {
		System.out.println("\nSeleccione uma das opções existentes: ");
		System.out.println("1. Adiciona Prato");
		System.out.println("2. Remove Prato");
		System.out.println("3. Imprime Ementa");
		System.out.println("4. Menu Anterior");
		int op = in.nextInt();
		
		while (op<1 || op>4) {
			System.err.println("\nERRO: Opção inválida! Escolha uma opção de 1 a 4");
			op = in.nextInt();
		}
		
		switch (op) {
			case 1: { adicionaPrato(); break; }
			case 2: { removePrato(); break; }
			case 3: { imprimeEmenta(); break; }
			case 4: { menuPrincipal(); }
		}
	}
	
	public static void adicionaPrato() {
		menuEmentas();
	}
	
	public static void removePrato() {
		menuEmentas();
	}
	
	public static void imprimeEmenta() {
		menuEmentas();
	}
}