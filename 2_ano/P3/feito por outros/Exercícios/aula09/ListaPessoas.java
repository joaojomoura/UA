package aula09;

public class ListaPessoas {
	private int nPessoas = 0;
	private Node in = null;
	private Node out = null;
	
	public boolean addPessoa(Pessoa pessoa) {
		assert (!isFull());
		
		if(!isEmpty() && search(pessoa.getNome())) {
			return false;
		}
		else {
			Node novo = new Node();
			novo.p = pessoa;
			if (isEmpty()) {
				in = out = novo;
			}
			else {
				out.next = novo;
				out = novo;
			}
			nPessoas++;
			return true;
		}
	}
	
	public boolean search (String nome) {
		if (isEmpty()) {
			return false;
		}
		else {
			Node aux = in;
			while (aux.next!=null && aux.p.getNome()!=nome) {
				aux = aux.next;
			}
			if (aux.p.getNome()==nome) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public boolean removePessoa(Pessoa pessoa) {
		assert(!isEmpty());
		String nome = pessoa.getNome();
		if (search(nome)==false) {
			return false;
		}
		else {
			Node aux = in;
			while (aux!=null && aux.p.getNome()!=nome) {
				aux = aux.next;
			}
			if (nPessoas==1) {
				in = out = null;
				nPessoas--;
				return true;
			}
			else if (aux == in) {
				in = aux.next;
				aux.next = null;
				nPessoas--;
				return true;
			}
			else {
				aux = aux.next;
				out = null;
				nPessoas--;
				return true;
			}
		}
	}
	
	public boolean isEmpty()
	{
		return nPessoas == 0;
	}
	
	public boolean isFull()
	{
		return false;
	}
	
	public int totalPessoas() {
		return nPessoas;
	}
	
	public Node getIn() {
		return in;
	}

	public Node getOut() {
		return out;
	}

	public Iterator iterator() {
		return this.new ListaIterator();
	}
	
	public class ListaIterator implements Iterator {
		private Node aux = in;
		
		public boolean hasNext() {
			return aux.next!=null;
		}

		public Pessoa next() {
			if (hasNext()) {
				Node temp = aux;
				aux = aux.next;
				return temp.p;
			}
			throw new IndexOutOfBoundsException("Não existe elemento seguinte!");
		}

		public void remove() {
			throw new UnsupportedOperationException("Operação não suportada!");
		}
	}
	
	private class Node 
	{
		Pessoa p;
	 	Node next;
	}
}
