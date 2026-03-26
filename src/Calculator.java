import java.util.Scanner;

public class Calculator {
    
    // Method to add two numbers
    public static double add(double a, double b) {
        return a + b;
    }
    
    // Method to subtract two numbers
    public static double subtract(double a, double b) {
        return a - b;
    }
    
    // Method to multiply two numbers
    public static double multiply(double a, double b) {
        return a * b;
    }
    
    // Method to divide two numbers
    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Error: Division by zero is not allowed!");
        }
        return a / b;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        System.out.println("==========================");
        System.out.println("   Basic Calculator");
        System.out.println("==========================");
        
        while (running) {
            System.out.println("\nSelect operation:");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Exit");
            System.out.print("\nEnter choice (1-5): ");
            
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // Clear invalid input
                continue;
            }
            
            if (choice == 5) {
                System.out.println("\nThank you for using the calculator. Goodbye!");
                running = false;
                continue;
            }
            
            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice! Please select 1-5.");
                continue;
            }
            
            System.out.print("Enter first number: ");
            double num1;
            try {
                num1 = scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
                continue;
            }
            
            System.out.print("Enter second number: ");
            double num2;
            try {
                num2 = scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
                continue;
            }
            
            double result;
            String operator;
            
            switch (choice) {
                case 1:
                    result = add(num1, num2);
                    operator = "+";
                    break;
                case 2:
                    result = subtract(num1, num2);
                    operator = "-";
                    break;
                case 3:
                    result = multiply(num1, num2);
                    operator = "*";
                    break;
                case 4:
                    try {
                        result = divide(num1, num2);
                        operator = "/";
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    break;
                default:
                    System.out.println("Invalid choice!");
                    continue;
            }
            
            System.out.println("\n--------------------------");
            System.out.printf("Result: %.2f %s %.2f = %.2f%n", num1, operator, num2, result);
            System.out.println("--------------------------");
        }
        
        scanner.close();
    }
}
