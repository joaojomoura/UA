package aula10;

public interface Iterator<T> {
	boolean hasNext();
	T next();
	void remove();
}
