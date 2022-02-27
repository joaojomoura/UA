import Shared.*;
import Secondary_language.*;
import java.util.*;
import java.io.FileNotFoundException;

public class Program {
   @SuppressWarnings("unchecked")
   public static void main(String[] args) throws FileNotFoundException
   {
      CScanner scanner = new CScanner(System.in);

      Table Luffy = new Table(new KeyValuePair[] {new KeyValuePair<String, Column.Type>("anime", Column.Type.String),new KeyValuePair<String, Column.Type>("gatinhos", Column.Type.String)});
      Luffy.InsertLine(new Object[]{"OnePiece","Miau"});
      System.out.println(Luffy);
      TableReaderWriter.SaveTable(Luffy, "monkey.table");

      scanner.close();
   }
}
