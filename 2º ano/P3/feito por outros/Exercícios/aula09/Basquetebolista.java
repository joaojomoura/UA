package aula09;

public class Basquetebolista extends jogDecorator {

	public Basquetebolista(JogadorInterface j) {
		super(j);
	}

	public void joga() {
		super.joga();
		System.out.print(" basquetebol");
	}

	public void lanca() {
		System.out.println("--> Lança.");
	}

	public void passa() {
		System.out.println("--> Passa.");
	}
}
