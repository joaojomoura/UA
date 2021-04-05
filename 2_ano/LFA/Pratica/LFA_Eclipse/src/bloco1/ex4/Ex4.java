package bloco1.ex4;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import bloco1.ex5.*;

public class Ex4 {
	static HashMap <String,Integer> text = new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = 0;
		Path path = Paths.get("/Users/slowbro/Desktop/UA/UA/2_ano/LFA/Pratica/Bloco_1/bloco1/numbers.txt");
		try {
			Files.lines(path)
				.map(line -> line.split("[ -]+"))
				.forEach(s -> text.put(s[1], Integer.parseInt(s[0])));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			while(true) {
				for(String s : Ex5.read()) {
					if(text.containsKey(s)) {
						number = text.get(s);
						System.out.print(number + " ");
						
					}
					else
						throw new Exception (s + " is not in the table");
				}
				System.out.println();
				number = 0;
			}
			
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
