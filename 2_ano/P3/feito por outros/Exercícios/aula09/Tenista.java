package aula09;

public class Tenista extends jogDecorator {

	public Tenista(JogadorInterface j) {
		super(j);
	}

	public void joga() {
		super.joga();
		System.out.print(" t�nis");
	}

	public void serve() {
		System.out.println("--> Serve.");
	}

}
