/**
 * 
 */
package aula10.ex2;

import java.util.Iterator;

import aula3.ex2.*;

/**
 * @author João Moura
 *
 */
public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearchTree<Figura> bst = new BinarySearchTree<Figura>(); 
		
		bst.insert(new Circulo (1,3, 1));
		bst.insert(new Circulo (1,5, 1));
		bst.insert(new Quadrado(3,4, 2));
		bst.insert(new Rectangulo(1,2, 2,5));
		
		Iterator<Figura> it = bst.iterator();
		printSet(it);
		System.out.println("Soma da Area de Lista de Figuras: " + sumArea(bst.iterator()));
	}
	
	private static <T> double sumArea(Iterator<T> it) {
		double sum = 0;
		try{
			while(it.hasNext()){
				sum += ((Figura)(it.next())).area();
			}
		}catch(ClassCastException e){
			e.printStackTrace();
		}
		return sum;
	}

	private static <T> void printSet(Iterator<T> iterator) {
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}

	

}
