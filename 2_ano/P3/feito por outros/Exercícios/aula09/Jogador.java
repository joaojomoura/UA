package aula09;

public class Jogador implements JogadorInterface {

	private String nome;

	public Jogador(String inome) {
		this.nome = inome;
	}

	public void joga() {
		System.out.print("\n" + nome + " joga");
	}
}
