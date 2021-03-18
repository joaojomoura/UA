/**
 * 
 */
package aula8.ex3;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author João Moura
 *
 */
public class ReadFile {
	private static Random rand = new Random();

    public static void parse(Collection<Question> q, String filename) 
    throws IOException 
    {
    	Path file = Paths.get(filename);
    	List<String> lines = Files.readAllLines(file);
//    	BufferedReader file = new BufferedReader(new FileReader(filename));
//    	String linhas[] = (file.lines()).toArray(String[]::new);
    	for(String linha: lines)
		{
			String parts[] = linha.split("&&");
			q.add(new Question(parts[0].split(":")[1], parts[1], parts[2], Integer.parseInt(parts[6]), parts[2], parts[3], parts[4], parts[5]));
		}
//    	file.close();
    }
        
    public static <T> T[] scrambleArray(T[] ops)
    {
        T tmp;
        for (int i = ops.length - 1, idx; i > 0; i--)
        {
            idx = rand.nextInt(i + 1);
            tmp = ops[idx];
            ops[idx] = ops[i];
            ops[i] = tmp;
        }
        return ops;
    }

    public static <T extends Comparable<T>> T[] sort(T[] arr)
    {
        Arrays.sort(arr);
        return arr;
    }
}
