//Aula 06 Ex_6


import java.util.Scanner;
import java.lang.Math;

public class Ex6_6{

    static Scanner sc = new Scanner (System.in);

    public static void main (String [] args){

    	String sentence = get_String();
    	check_letter(sentence);

    }

    //Get a string from user
    public static String get_String ()
    {
    	String s = new String();

    	System.out.print("Frase: ");
    	s = sc.nextLine();

    	return s;
    }
	
	//???????
    public static void check_letter (String s)
    {
    	boolean repeat = false;
    	char [] c = new char [s.length()];

        for (int i = 0; i <s.length(); i++)
        {
            c[i] = s.charAt(i);
            int find = 0;
            for (int j = 0; j <= i; j++)
            {
                // If any matches found 
                if (s.charAt(i) == c[j])  
                    find++;                 
            } 
  
            if (find == 1)  
                System.out.print(s.charAt(i));
            
        }

    }
}