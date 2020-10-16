package aula12;

public interface Iterator<T> {
	public T next();
	public boolean hasNext();
	public void remove();
}
