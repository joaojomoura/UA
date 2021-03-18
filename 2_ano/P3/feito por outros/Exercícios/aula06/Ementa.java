package aula06;

public class Ementa {
	
	private ListaLigada ementa = new ListaLigada();
	private String nome;
	private String local;
	
	public Ementa (String nome, String local) {
		this.nome = nome;
		this.local = local;
	}

	public String getNome() {
		return nome;
	}

	public String getLocal() {
		return local;
	}
	
	public void addPrato(Prato prato, DiaSemana dia) {
		ementa.in(prato, dia);
	}
	
	public String toString() {
		ementa.listar();
		return "\n";
	}
}
