package bloco1.ex3;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class Ex3 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * Variables
		 */
		Stack <Double> stack = new Stack <>();
		Scanner in = new Scanner (System.in);
		String [] input = in.nextLine().split(" ");
		int count = 0;
		
		/**
		 * Push to stack all the numbers
		 */
		for (String s : input) {
			if(!isNumeric(s))
				break;
			stack.push(Double.parseDouble(s));
			count++;
			System.out.print("Stack: [");
			stack.forEach(x -> System.out.print(x + " "));
			System.out.println("]");
		}
		/**
		 * Errors if the number of operands is less than two
		 */
		if(count == 1) {
			System.err.println("Missing one operand");
			System.exit(0);
		}
		if(stack.isEmpty()) {
			System.err.println("No Operands");
			System.exit(1);
		}
		/**
		 * 
		 * 
		 */
		
		try {
			while (stack.size() != 1) {

				double op1 = stack.pop();
				double op2 = stack.pop();
				String op = input[count];

				double res = result(op, op1, op2);
				stack.push(res);

				System.out.print("Stack: [");
				stack.forEach(x -> System.out.print(x + " "));
				System.out.println("]");

				if (count != input.length - 1)
					count++;
			} 
		} catch (Exception e) {
			System.err.println(e);
		}
		in.close();
	}
	
	
	/**
	 * 
	 * @param String 
	 * @return true if is a number or false if not
	 */
	static boolean isNumeric(String s) {
		try {
			Double.parseDouble(s);
			return true;
		}
		catch(NumberFormatException e) {
			return false;
		}
	}
	
	/**
	 * 
	 * @param op
	 * @param op1
	 * @param op2
	 * @return the result between ops
	 */
	static double result (String op, double op1, double op2) {
		
		
		switch(op) {
			case "+":
				return op1 + op2;
			case "-":
				return op1 - op2;
			case "*":
				return op1 * op2;
			case "/":
				return op1 / op2;
			default:
				throw new InputMismatchException("Invalid Operator");
			
		}
	}	
}
