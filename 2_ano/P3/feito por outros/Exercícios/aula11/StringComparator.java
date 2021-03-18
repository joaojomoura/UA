package aula11;
import java.util.Comparator;

public class StringComparator implements Comparator<String> {

	public int compare(String um, String dois) {
		if (um!=null && dois!=null) {
			return um.compareTo(dois);
		}
		return 0;
	}
}
