package aula07;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class WriteReadObjFile {
	public static Object randObject(int max) {
		switch ((int) (Math.random() * (max))) {
			case 0:
				return new Data(11,2,2001);
			case 1:
				return new Pessoa("Maria Costa", 234342124, new Data(12,9,1972));
			case 2:
				return new Circulo(1,3, 1);
			default:
				return null;
		}
	}
	
	public static void writeObjectArray() throws IOException{
		FileOutputStream out = new FileOutputStream("src/aula07/File.txt");
		ObjectOutputStream s = new ObjectOutputStream(out);
		
		try {
			Object[] array = new Object[10];
			for (int i = 0; i < array.length; i++)
			{
				array[i] = randObject(3);
				s.writeObject(array[i]);
				s.flush();
			}
			s.close();
		} catch (IOException e) {
			System.err.println("erro1");
		}
	}
	
	public static void readFile() throws IOException, ClassNotFoundException{
		FileInputStream in = new FileInputStream("src/aula07/File.txt");
		ObjectInputStream s = new ObjectInputStream(in);
		
		try{
			for (int i = 0; i < 10; i++)
			{
				System.out.println(s.readObject().toString());
			}
			s.close();
		} catch (IOException e) {
			System.err.println("erro2");
		}
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		writeObjectArray();
		readFile();
	}
}