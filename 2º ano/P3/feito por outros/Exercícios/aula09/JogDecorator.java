package aula09;

abstract class jogDecorator implements JogadorInterface {

	private JogadorInterface j;

	public jogDecorator(JogadorInterface i) {
		this.j = i;
	}

	public void joga() {
		j.joga();
	}

}
