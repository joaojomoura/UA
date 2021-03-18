package aula12;
import java.util.Arrays;

public class Organizacao {
	private String nome;
	private int cont = 0;
	private Pais[] paises;

	public Organizacao(String nome) {
		this.nome = nome;
		this.paises = new Pais[20];
	}
	
	public boolean add(Pais pais) {
		if (exists(pais)) {
			return false;
		}
		else {
			if (cont == paises.length) {
				Pais[] temp = new Pais[cont+20];
				System.arraycopy(paises, 0, temp, 0, cont+20);
				paises = temp;
			}
			paises[cont] = pais;
			cont++;
			return true;
		}
	}
	
	public boolean remove(Pais pais) {
		if (!exists(pais)) {
			return false;
		}
		else {
			for (int i=0; i<cont; i++) {
				if (paises[i].equals(pais)) {
					for (int j=i; j<cont; j++) {
						paises[i] = paises[j];
						cont--;
					}
				}
			}
			return true;
		}
	}
	
	public boolean exists(Pais pais) {
		if (cont == 0) {
			return false;
		}
		else {
			for (int i=0; i<cont; i++) {
				if (paises[i].equals(pais)) {
					return true;
				}
			}
			return false;
		}	
	}
	
	public Iterator<Pais> iterator() {
		return new MyIterator<Pais>();
	}
	
	public class MyIterator<T> implements Iterator<T>{
		private int indice = 0;
		
		@SuppressWarnings("unchecked")
		public T next() {
			if (hasNext()) {
				indice++;
				return (T) paises[indice];
			}
			else {
				throw new IndexOutOfBoundsException("Não existe elemento seguinte!");
			}
		}
		
		public boolean hasNext() {
			return indice < cont-1;
		}

		public void remove() {
			throw new UnsupportedOperationException("Operação não suportada!");
		}
	}
	
	public String getNome() {
		return nome;
	}

	public Pais[] getPaises() {
		return paises;
	}
	
	@Override
	public String toString() {
		return "Organizacao: " + nome + ", paises: "+listarPaises();
	}
	
	public String listarPaises() {
		for (int i=0; i<cont; i++) {
			System.out.println("   "+paises[i]);
		}
		
		return "";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Organizacao other = (Organizacao) obj;
		if (!Arrays.equals(paises, other.paises))
			return false;
		return true;
	}
}
