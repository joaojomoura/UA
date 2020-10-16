package aula09;

public class VectorPessoas {
	private Pessoa lista[] = new Pessoa[50];
	private int nPessoas = 0;

	public VectorPessoas() {
	}

	public boolean isFull() {
		return lista.length == nPessoas;
	}
	
	public void aumentaLista() {
		Pessoa[] aux = new Pessoa[nPessoas+10];
		System.arraycopy(lista, 0, aux, 0, aux.length);
		lista = aux;
	}
	
	public boolean addPessoa(Pessoa p) {
		if (isFull())
			aumentaLista();
		
		lista[nPessoas] = p; nPessoas++;
		return true;
	}
	
	public boolean removePessoa(Pessoa p){
		for (int i=0; i<nPessoas; i++) {
			if (lista[i].equals(p)) {
				for (int j=i; j<nPessoas; j++) {
					lista[j] = lista[j+1];
				}
				nPessoas--;
				return true;
			}
		}
		return false;
	}
	
	public int totalPessoas() {
		return nPessoas;
	}
	
	public class VetorIterator implements Iterator {
		private int i=0;
		
		public boolean hasNext() {
			return i<nPessoas;
		}

		public Pessoa next() {
			if (hasNext()) {
				return lista[i++];
			}
			throw new IndexOutOfBoundsException("Não existe elemento seguinte!");
		}

		public void remove() {
			removePessoa(next());
		}
	}
	
	public Iterator iterator() {
		return new VetorIterator();
	}
}
