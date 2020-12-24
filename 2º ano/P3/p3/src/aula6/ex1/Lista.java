/**
 * 
 */
package aula6.ex1;

/**
 * @author Joao Moura
 *
 */
public class Lista <E extends Comparable <E>>{
	private Node<E> first = null;
	  private Node<E> last = null;
	  private int size = 0;

	  /**
	   * {@code LinkedList} constructor, empty so far.
	   */
	  public Lista() { }

	  /** Returns the number of elements in the list.
	   * @return Number of elements in the list
	   */
	  public int size() { return size; }

	  /** Checks if the list is empty.
	   * @return  {@code true} if list empty, otherwise {@code false}.
	   */
	  public boolean isEmpty() { return size == 0; }

	  /** Returns the first element in the list.
	   * @return  First element in the list
	   */
	  public E first() {
	    assert !isEmpty(): "empty!";

	    return first.elem;
	  }

	  /** Returns the last element in the list.
	   * @return Last element in the list
	   */
	  public E last() {
	    assert !isEmpty(): "empty!";

	    return last.elem;
	  }
	  
	  public void insert(E e) {
	    first = insert(first,e);
	    size++;
	  }
	  private Node<E> insert(Node<E> n, E e) {
	    if (n==null || e.compareTo(n.elem) < 0)
	      return new Node<E>(e,n);
	    n.next = insert(n.next,e);
	    return n;
	  }

	  /** Removes the first element in the list.
	   */
	  public void removeFirst() {
	    assert !isEmpty(): "empty!";
	    first = first.next;
	    size--;
	    if (isEmpty())
	      last = null;
	  }
	  
	  // Checks whether the value x is present 
	    // in linked list 
	    public int search(Node<E> head, E x) 
	    { 
	        int index = 0;
	        Node <E> current = first;
	        while(current != null) {
	        	if(current.elem.equals(x))
	        		return index;
	        	index++;
	        	current = current.next;
	        }
	        return -1;
	    } 
	    
	  public void deleteNode (int position) {
		// If linked list is empty 
	        if (first == null) 
	            return; 
	  
	        // Store head node 
	        Node <E> temp = first; 
	  
	        // If head needs to be removed 
	        if (position == 0) 
	        { 
	            first = temp.next;   // Change head
	            size --;
	            return; 
	        }
	        
	        // Find previous node of the node to be deleted 
	        for (int i = 0; temp != null && i < position - 1; i++) 
	            temp = temp.next; 
	  
	        // If position is more than number of nodes 
	        if (temp == null || temp.next == null) 
	            return; 
	  
	        // Node temp->next is the node to be deleted 
	        // Store pointer to the next of node to be deleted 
	        Node <E> next = temp.next.next; 
	  
	        temp.next = next;  // Unlink the deleted node from list
	  }
	  
	  public void delete(E e) {
		  deleteNode(search(first,e));
		  size--;
	  }

	  /** Removes all elements.
	   */
	  public void clear() {
	    first = last = null;
	    size = 0;
	  }

	  /** Checks if the given element exists in the list.
	   * @param e an element
	   * @return {@code true} if the element exists and {@code false} otherwise
	   */
	  public boolean contains(E e) { 
	    return contains(first, e); 
	  }
	  private boolean contains(Node<E> n, E e) {
	    if (n == null) return false;
	    if (n.elem == null) return e == null; 
	    if (n.elem.equals(e)) return true; 
	    return contains(n.next, e);
	  }
	  
	  /**
	   * @return an array with all the elements in the list
	   */
	  
	  public E[] toArray(E[] a) {
		  E[] tmp = (E[])java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
		  int index = 0;
		  for(Node<E> n = first; n != null; n = n.next) {
			  tmp[index++] = n.elem;
		  }
		  return tmp;
	  }
	  
	  class Node<E> {

		  final E elem;
		  Node<E> next;

		  Node(E e, Node<E> n) {
		    elem = e;
		    next = n;
		  }

		  Node(E e) {
		    elem = e;
		    next = null;
		  }

		}

}
