//Aula 7 Ex 1

import java.util.Scanner;
import java.io.*;

public class Ex7_1
{

	public static void main (String [] args) throws IOException
	{
		String name = " ";
		do{
			name = file_name();
		}while(validate_file(name) == false);

		read_file(name);
	}

	//get the file name from user
	public static String file_name ()
	{
		Scanner sc = new Scanner (System.in);
		System.out.print("Nome do ficheiro: ");
		String s = sc.nextLine();
		return s;

	}

	// read the file which name was given by the user
	public static void read_file (String s) throws IOException
	{
		File fin = new File (s);
		Scanner read = new Scanner (fin);
		String line = " ";

		//read the file
		while(read.hasNextLine())
		{
			line = read.nextLine();
			System.out.println(line);
		}


		read.close();
	}

	public static boolean validate_file (String s) throws IOException
	{

		File fin = new File (s);

		if(!fin.exists())
		{
			System.out.println("ERROR: input file " + s + " does not exist!");
			return false;
		}
		else if (!fin.canRead())
		{
			System.out.println("ERROR: cannot read from input file " + s + "!");
			return false;
		}
		return true;
	}


}