package aula09;

public class Futebolista extends jogDecorator {

	public Futebolista(JogadorInterface j) {
		super(j);
	}

	public void joga() {
		super.joga();
		System.out.print(" futebol");
	}

	public void remata() {
		System.out.println("--> Remata.");
	}

	public void passa() {
		System.out.println("--> Passa.");
	}
}
