package bloco1.ex2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Ex2 {
	static HashMap <String,Double> assign = new HashMap<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String s;
		String [] expression;
		do {
			s = in.nextLine();
			expression = s.split(" ");
			
			try {
				if(expression.length >= 3 && expression[1].equals("=")) {
					assign.put(expression[0], operation(Arrays.copyOfRange(expression, 2, expression.length)));
					System.out.println(expression[0] + " = " + assign.get(expression[0]));	
				}
				else
					System.out.println(s + " = " + operation(expression));
			}catch(Exception e) {
				System.err.println(e);
			}
			
		}while(in.hasNextLine());
		
		in.close();

	}
	
	static double value(String s) throws Exception {
		try {
			return Double.parseDouble(s);
		}
		catch(NumberFormatException e) {
			try {
				return assign.get(s);
			}
			catch(Exception er) {
				throw new Exception("Variable not found");
			}
		}
	}
	
	static double operation(String [] s) throws Exception {
		double result = 0;
		if(s.length == 1)
			return value(s[0]);
		
		else if (s.length == 3) {
			double op1 = value(s[0]);
			double op2 = value(s[2]);
			switch (s[1]) {

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
				result = op1 * op2;
				break;

			default:
				System.err.println("ERROR: Invalid operation (use +, -, *, /)");

			}
		}
		else
			throw new Exception("Invalid Expression");
		return result;
	}
	
	

}
