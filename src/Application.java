//package com.ahmed.calculator;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		if (args.length > 0) {
			String expression = String.join("", args);
			calculateAnswer(expression);
			
		} else {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter operation (e.g., add, sub, mul, div or factorial):");
			String operation = scanner.next();
			
			switch (operation.toLowerCase()) {
			case "add":
				System.out.println("Enter the first operrand:");
				double num1 = scanner.nextDouble();
				System.out.println("Enter the second operand:");
				double num2 = scanner.nextDouble();
				System.out.println ("Result: " + add(num1, num2));
				break;
			case "sub":
				System.out.println("Enter the first operrand:");
				double num3 = scanner.nextDouble();
				System.out.println("Enter the second operand:");
				double num4 = scanner.nextDouble();
				System.out.println ("Result: " + sub(num3, num4));
				break;
			case "mul":
				System.out.println("Enter the first operrand:");
				double num5 = scanner.nextDouble();
				System.out.println("Enter the second operand:");
				double num6 = scanner.nextDouble();
				System.out.println ("Result: " + mul(num5, num6));
				break;
			case "div":
				System.out.println("Enter the first operrand:");
				double num7 = scanner.nextDouble();
				System.out.println("Enter the second operand:");
				double num8 = scanner.nextDouble();
				if  (num8 == 0) {
					System.out.println ("Cannot Divide by zero");
				} else {
					System.out.println ("Result: " + div(num7, num8));
				}
				break;
			case "factorial":
				System.out.println("Enter a number: ");
				double number = scanner.nextDouble();
				System.out.println ("Result: " + factorial(number));
				break;
			}
			
			scanner.close();
		}	

	}
	
	private static void calculateAnswer(String expression) {
		if (expression.endsWith("!")) {
			 double number = Double.parseDouble(expression.substring(0, expression.length() - 1));
		     System.out.println("Result: "+ factorial(number));
		}
		else {
            String operator = "";
            for (char ch : expression.toCharArray()) {
                if (!Character.isDigit(ch)) {
                    operator = Character.toString(ch);
                    break;
                }
            }
            
            if (!(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/"))) {
                System.out.println("Invalid operator. Use +, -, *, or /.");
                return;
            }
			
            if (!operator.isEmpty()) {
                String[] parts = expression.split("\\" + operator);
                if (parts.length == 2) {
                    double num1 = Double.parseDouble(parts[0]);
                    double num2 = Double.parseDouble(parts[1]);
                    switch(operator) {
        		    case "+":
        		    	System.out.println("Result: " + add(num1, num2));
        		        break;
        		    case "-":
        		    	System.out.println("Result: " + sub(num1, num2));
        		        break;
        		    case "*":
        		    	System.out.println("Result: " + mul(num1, num2));
        		        break;
        		    case "/":
        		    	if (num2 == 0) {
        	                System.out.println("Cannot divide by zero");
        	            } else {
        	                System.out.println("Result: " + div(num1, num2));
        	            }
        		    	break;
        		   
        		    }
                } 
            }
		}
	}
	
	public static double add(double a, double b) {
		return a+b;
	}
	
	public static double sub(double a, double b) {
		return a-b;
	}
	
	public static double mul(double a, double b) {
		return a*b;
	}
	
	public static double div(double a, double b) {
		return a/b;
	}

	public static double factorial(double n) {
		if (n<=1) {
			return 1;
		} else {
			return n*factorial(n-1);
		}
	}
	
}


