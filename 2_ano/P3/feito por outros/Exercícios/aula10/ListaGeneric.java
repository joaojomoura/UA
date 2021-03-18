package aula10;

public class ListaGeneric<T> {
	private int nTotal = 0;
	private Node<T> in = null;
	private Node<T> out = null;
	
	public boolean addElem(T elem) {
		assert (!isFull());
		
		if(!isEmpty() && search(elem)) {
			return false;
		}
		else {
			Node<T> novo = new Node<T>();
			novo.elem = elem;
			if (isEmpty()) {
				in = out = novo;
			}
			else {
				out.next = novo;
				out = novo;
			}
			nTotal++;
			return true;
		}
	}
	
	public boolean search (T obj) {
		if (isEmpty()) {
			return false;
		}
		else {
			Node<T> aux = in;
			while (aux.next!=null && aux.elem!=obj) {
				aux = aux.next;
			}
			if (aux.elem==obj) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public boolean removeElem(T elem) {
		assert(!isEmpty());
		T objecto = elem;
		if (search(objecto)==false) {
			return false;
		}
		else {
			Node<T> aux = in;
			while (aux!=null && aux.elem!=objecto) {
				aux = aux.next;
			}
			if (nTotal==1) {
				in = out = null;
				nTotal--;
				return true;
			}
			else if (aux == in) {
				in = aux.next;
				aux.next = null;
				nTotal--;
				return true;
			}
			else {
				aux = aux.next;
				out = null;
				nTotal--;
				return true;
			}
		}
	}
	
	public boolean isEmpty()
	{
		return nTotal == 0;
	}
	
	public boolean isFull()
	{
		return false;
	}
	
	public int totalElem() {
		return nTotal;
	}
	
	public Node<T> getIn() {
		return in;
	}

	public Node<T> getOut() {
		return out;
	}

	public Iterator<T> iterator() {
		return this.new ListaIterator<T>();
	}
	
	@SuppressWarnings("hiding")
	public class ListaIterator<T> implements Iterator<T> {
		@SuppressWarnings("unchecked")
		private Node<T> aux = (Node<T>) in;
		
		public boolean hasNext() {
			return aux.next!=null;
		}

		public T next() {
			if (hasNext()) {
				Node<T> temp = aux;
				aux = aux.next;
				return temp.elem;
			}
			throw new IndexOutOfBoundsException("Não existe elemento seguinte!");
		}

		public void remove() {
			throw new UnsupportedOperationException("Operação não suportada!");
		}
	}
	
	@SuppressWarnings("hiding")
	private class Node<T>
	{
		T elem;
	 	Node<T> next;
	}
}
