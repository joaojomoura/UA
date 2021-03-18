package aula03;

public class Agenda {
	//ATRIBUTOS
	private Pessoa[] p = new Pessoa[100]; 
	private int maxPessoas = 100; //NUMERO MAXIMO DE REGISTOS
	private int np = 0;  //NUMERO DE REGISTOS REALIZADOS
	
	public void inserir(String nome, int BI, Data dataNasc) {
		assert !isFull();

		p[np] = new Pessoa(nome, BI, dataNasc);
		np++;
	}
	
	public boolean isFull() {
		return ((maxPessoas - 1) == np);
	}
	
	public void imprime() {
		String ret = "";

		for (int i = 0; i < np; i++)
			ret = ret + "\n" + p[i].toString();

		System.out.println(ret);
	}
	
	public void apagar(String nome) {
		assert !isFull();

		for (int i = 0; i < np; i++) {
			if (p[i].getNome().equals(nome)) {
				for (int j = i; j < np - 1; j++)
					p[j] = p[j + 1];
				p[np] = null;
				np--;
			}
		}
	}
	
	public void ordenaNome() {
		for (int i = 0; i < np; i++) {
			for (int j = 0; j < np - i - 1; j++) {
				if (p[j].getNome().compareTo(p[j + 1].getNome()) > 0) {
					permuta(j, j + 1);
				}
			}
		}
	}

	public void ordenaBI() {
		for (int i = 0; i < np; i++) {
			for (int j = 0; j < np - i - 1; j++) {
				if (p[j].getBI() > p[j + 1].getBI()) {
					permuta(j, j + 1);
				}
			}
		}
	}

	private void permuta(int i, int j) {
		Pessoa temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}
}