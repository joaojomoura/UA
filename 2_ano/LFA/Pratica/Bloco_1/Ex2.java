import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex2 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
       var s = "";
       double op1, op2,result;
       String [] splited_s;
       System.out.println("Op1 (+,-,*,/) Op2");
       do{
            
            
            s = sc.nextLine();
            splited_s = s.split(" ");
            try{
                if( splited_s.length == 3){
                    op1 = Double.parseDouble(splited_s[0]);
                    op2 = Double.parseDouble(splited_s[2]);
                    
                    switch(splited_s[1]) {
                        case "+":
                            result = op1 + op2;
                            break;
                        
                        case "-":
                            result = op1 - op2;
                            break;
                        
                        case "/":
                            result = op1 / op2;
                            break;
                        
                        case "*":
                            result = op2 * op2;
                            break;
                        
                        default:
                            System.err.println("ERROR: Invalid operation (use +,-,*,/)");
                            continue;
                    }
                    System.out.println(s + "= " + result);
                }
            }catch(Exception e){
                System.err.println("Invalid Operand");
            }
            System.out.println("Op1 (+,-,*,/) Op2");
        }while(sc.hasNextLine());
     }
     
     public static void atr(String [] s){
        if(s.length >= 3){
            if(s[1].equals('=')){
                if(Character.isLetter(s[0].charAt(0))){
                    
                }
            }
        }
     }
}