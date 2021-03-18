package aula06;

public abstract class UtilCompare implements Comparable{
	
	public static Comparable findMax(Comparable[] c) {
		int iMax = 0;	
		for(int i=1; i<c.length; i++ ) {
			if(c[i].compareTo(c[iMax]) >0 ) {
				iMax = i;
			}
		}
		return c[iMax];
	}
	
	public static void sortArray(Comparable[] c) {
		for (int i=0; i<c.length-1; i++) {
			for (int j=i+1; j<c.length; j++) {
				if (c[i].compareTo(c[j]) > 0) {
					Comparable aux = c[j];
					c[j] = c[i];
					c[i] = aux;
				}
			}
		}
	}
}
