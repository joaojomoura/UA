package Shared;

import java.io.InputStream;
import java.util.*;

public class CScanner 
{
    private Scanner scanner;

    public CScanner(InputStream stream)
    {
        scanner = new Scanner(stream);
    }

    public String nextLine()
    {
        return scanner.nextLine();
    }

    public int nextInt()
    {
        try
        {
            return Integer.parseInt(scanner.nextLine());
        }
        catch (NumberFormatException e)
        {
            return 0;
        }
    }

    public Double nextDouble()
    {
        try
        {
            return Double.parseDouble(scanner.nextLine());
        }
        catch (NumberFormatException e)
        {
            return 0.0;
        }
    }

    public void close()
    {
        scanner.close();
    }
}
