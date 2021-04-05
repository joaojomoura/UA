package bloco1.ex5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;


public class Ex5 {
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
				for(String s : read()) {
					if(text.containsKey(s)) {
						int n = text.get(s);
						if(n  >= 100 && number < n) {
							number = n * number;
						}
						else if(n >= 100 && number > n) {
							int last = 0;
							for(int i = 10; i < Integer.MAX_VALUE; i*=10) {
								last = number % i;
								if(last != 0)
									break;
							}
							n = n * last;
							number = (number - last) + n;
							
						}	
						else
							number += n;
					}
					else
						throw new Exception (s + " is not in the table");
				}
				System.out.println(number);
				number = 0;
			}
			
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	public static String[] read() {
		
		Scanner in = new Scanner (System.in);
		
		String readFromUser = in.nextLine();
		String[] s = readFromUser.replaceAll(" and ", " ").split("[ ,-]+");
		
		
		return s;
	}
	

}
