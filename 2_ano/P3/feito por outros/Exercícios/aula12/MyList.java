package aula12;

public class MyList<T> {
	@SuppressWarnings("unchecked")
	private T[] lista = (T[]) new Object[20];
	private int cont = 0;
	
	@SuppressWarnings("unchecked")
	public boolean add(T obj) {
		if (exists (obj)) {
			return false;
		}
		else {
			if (cont == lista.length) {
				T[] temp = (T[]) new Object[cont+20];
				System.arraycopy(lista, 0, temp, 0, cont+20);
				lista = temp;
			}
			lista[cont] = obj;
			cont++;
			return true;
		}
	}
	
	public boolean remove(T obj) {
		if (!exists(obj)) {
			return false;
		}
		else {
			for (int i=0; i<cont; i++) {
				if (lista[i].equals(obj)) {
					for (int j=i; j<cont; j++) {
						lista[i] = lista[j];
						cont--;
					}
				}
			}
			return true;
		}
	}
	
	public boolean exists (T obj) {
		if (cont == 0) {
			return false;
		}
		else {
			for (int i=0; i<cont; i++) {
				if (lista[i].equals(obj)) {
					return true;
				}
			}
			return false;
		}
	}

	@Override
	public String toString() {
		for (int i=0; i<cont; i++) {
			System.out.println("   "+lista[i]);
		}
		
		return "";
	}
	
	public Iterator<T> iterator() {
		return new MyIterator<T>();
	}
	
	@SuppressWarnings("hiding")
	public class MyIterator<T> implements Iterator<T>{
		private int indice = -1;
		
		@SuppressWarnings("unchecked")
		public T next() {
			if (hasNext()) {
				indice++;
				return (T) lista[indice];
			}
			else {
				throw new IndexOutOfBoundsException("Não existe elemento seguinte!");
			}
		}
		
		public boolean hasNext() {
			return indice < cont;
		}

		public void remove() {
			throw new UnsupportedOperationException("Operação não suportada!");
		}
	}
}
