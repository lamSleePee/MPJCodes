import java.util.InputMismatchException;
import java.util.Scanner;

class OutputNotGreaterThanOneException extends Exception {
    public OutputNotGreaterThanOneException(String message) {
        super(message);
    }
}

public class TryCatchDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter first number (numerator): ");
            int numerator = sc.nextInt();

            System.out.print("Enter second number (denominator): ");
            int denominator = sc.nextInt();

            int result = numerator / denominator;

            if (result <= 1) {
                throw new OutputNotGreaterThanOneException(
                    "Output must be greater than 1. Please enter values so quotient > 1."
                );
            }

            System.out.println("Division result: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid integers only.");
        } catch (ArithmeticException e) {
            System.out.println("Error: Denominator cannot be zero.");
        } catch (OutputNotGreaterThanOneException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        } finally {
            sc.close();
            System.out.println("Program ended.");
        }
    }
}
