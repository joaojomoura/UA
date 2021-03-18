package aula10;

public class VectorGeneric<T> {
	@SuppressWarnings("unchecked")
	private T lista[] = (T[]) new Object[50];
	private int nTotal = 0;

	public VectorGeneric() {
	}

	public boolean isFull() {
		return lista.length == nTotal;
	}
	
	@SuppressWarnings("unchecked")
	public void aumentaLista() {
		T[] aux = (T[]) new Object[nTotal+10];
		System.arraycopy(lista, 0, aux, 0, aux.length);
		lista = aux;
	}
	
	public boolean addElem(T elem) {
		if (isFull())
			aumentaLista();
		
		lista[nTotal] = (T) elem; nTotal++;
		return true;
	}
	
	public boolean removeElem(T elem){
		for (int i=0; i<nTotal; i++) {
			if (lista[i].equals(elem)) {
				for (int j=i; j<nTotal; j++) {
					lista[j] = lista[j+1];
				}
				nTotal--;
				return true;
			}
		}
		return false;
	}
	
	public int totalElem() {
		return nTotal;
	}
	
	public class VectorIterator implements Iterator<T> {
		private int i=0;
		
		public boolean hasNext() {
			return i<nTotal;
		}

		public T next() {
			if (hasNext()) {
				return lista[i++];
			}
			throw new IndexOutOfBoundsException("Não existe elemento seguinte!");
		}

		public void remove() {
			removeElem(next());
		}
	}
	
	public Iterator<T> iterator() {
		return new VectorIterator();
	}
}

