
import java.util.Scanner;
import java.io.*;

public class Ex7_5{

    static Scanner sc = new Scanner (System.in);

    public static void main (String [] args) throws IOException
    {	


  
    	read_print_file(file);

    }

    public static void read_print_file (String namefile) throws IOException
    {
    	File fin =  new File (namefile);
    	if(verify_file(namefile,fin))
    	{


	    	{
	    		
	          		continue;
	      		}
	          		continue;
	      		}
	      			pw.println(line);
	      		}
	    	}
    		read.close();
    		pw.close();
		}
    }

    public static boolean verify_file (String namefile, File fin) throws IOException
    {
    	if(!fin.exists())
    	{
    		System.out.println("ERROR: input file " + namefile + " does not exists!");
    		return false;
    	}
    	else if (!fin.canRead())
    	{
    		System.out.println("ERROR: cannot read input file " + namefile );
    		return false;	
    	}

    }
}
