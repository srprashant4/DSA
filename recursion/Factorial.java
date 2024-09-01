/*
 * This is a code to compute the factorial of a number using recursion.
 * This code makes use of the concept of 'Functional Recursion'.
 */
import java.util.Scanner;

public class Factorial {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the input number: ");
        int n = scan.nextInt();
    
        System.out.println("The factorial of the entered number is: ");
        int fact = factorial(n);

        System.out.println(fact);

        scan.close();
    }

    public static int factorial(int n) {
        if(n == 0) {
            return 1;
        }

        return n * factorial(n - 1);
    }
}
