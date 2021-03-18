/**
 * 
 */
package aula5.ex1;

/**
 * @author João Moura
 *
 */
public class UtilCompare {

	@SuppressWarnings("unchecked")
	public static <T> Comparable<T> findMax (Comparable<T>[] a){
		int max = 0;
		
		for (int i = 0; i < a.length; i++) {
			if(a[i] != null && a[i].compareTo((T) a[max]) > 0)
				max = i;
		}
		
		return a[max];
	}
	
	public static <T> void sortArray(Comparable<T> toSort[])
	{
		mergeSort(toSort, 0, toSort.length);
	}
	
	public static <T> void mergeSort(Comparable<T> array[], int start, int end)
	{
		if (end - start > 1)
		{
			int tmp = (end + start) / 2;
			mergeSort(array, start, tmp);
			mergeSort(array, tmp, end);
			mergeArray(array, start, tmp, end);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> void mergeArray(Object[] array, int start, int mid, int end)
	{
		Comparable<T> arr[] = (T[]) new Comparable[end - start];
		
		int bottom = start;
		int top = mid;
		int currentPos = 0;
		
		
		while (bottom < mid && top < end)
		{
			if(((Comparable<T>) array[bottom]).compareTo((T) array[top]) < 0)
				arr[currentPos++] = (Comparable<T>) array[bottom++];
			else
				arr[currentPos++] = (Comparable<T>) array[top++];
		}
		
		while(bottom < mid)
			arr[currentPos++] = (Comparable<T>) array[bottom++];
		
		while(top < end)
			arr[currentPos++] = (Comparable<T>) array[top++];
		
		System.arraycopy(arr, 0, array, start, end - start);
	}
	
	

}
