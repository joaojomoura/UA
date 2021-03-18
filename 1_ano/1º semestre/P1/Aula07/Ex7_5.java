//Aula 07 Ex_5

import java.util.Scanner;
import java.io.*;

public class Ex7_5{

    static Scanner sc = new Scanner (System.in);

    public static void main (String [] args) throws IOException
    {	


    	String file = new String ();					//variable String to store the file name
    	System.out.print("Nome do ficheiro(.java): ");	//
    	do 												//ask the user
    	{												//for a file
    		file = sc.nextLine();						//
    	}while(file.isEmpty());							//
  
    	read_print_file(file);

    }

    public static void read_print_file (String namefile) throws IOException
    {
    	File fin =  new File (namefile);
    	//if the file verifies continue
    	if(verify_file(namefile,fin))
    	{
	    	Scanner read = new Scanner (fin);		//Scanner to read from file
	    	String line = new String();				//store each line from file
	    	boolean comment = false;				//see if is comment
	    	String fout = "output.java";			//output file
	    	File out = new File (fout);				//new file with the name output.java
	    	PrintWriter pw = new PrintWriter (out);	//Prints to the new file		


	    	while(read.hasNextLine())				//while there are lines
	    	{
	    		line = read.nextLine();				//store the line to this variable
	    		
	    		if (line.contains("/*")) {			//if it starts the group comment 
	          		comment = true;					//sets the comment to true and continues the loop
	          		continue;
	      		}
	      		if(line.contains("*/")){			//when the group comment ends 
	          		comment = false;				//sets the comment to false and continues the loop
	          		continue;
	      		}
	      		if(line.contains("//")){			//if it finds the // comment goes to the next line
	          		continue;
	      		}
	      		if(!comment){						//if the comment is false than it prints to file
	      			pw.println(line);
	      		}
	    	}
    		read.close();
    		pw.close();
		}
    	

    	
    }

    //verify if its a file and other stuff
    public static boolean verify_file (String namefile, File fin) throws IOException
    {
    	//returns faLse if doesn't exists
    	if(!fin.exists())
    	{
    		System.out.println("ERROR: input file " + namefile + " does not exists!");
    		return false;
    	}
    	//returns false if is a directory
    	// else if (!fin.isDirectory())
    	// {
    	// 	System.out.println("ERROR: input file " + namefile + " is a directory!");
    	// 	return false;
    	// }
    	//returns false if cannot be read
    	else if (!fin.canRead())
    	{
    		System.out.println("ERROR: cannot read input file " + namefile );
    		return false;	
    	}

    	return true; //if all fail returns true
    }
}