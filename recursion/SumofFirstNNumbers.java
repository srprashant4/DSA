/*
 * This code calculates the sum of first N natural numbers using recursion.
 * The code will be executed using two recursion techniques: 'paramterized' and 'functional' recursion.
 * ---> Paramterized Recursion: 
 * 1) Parameterized recursion refers to the use of parameters in recursive functions to carry additional information or state from one recursive call to another.
 * 2) In parameterized recursion, additional parameters are often used to keep track of the current state or intermediate results during the recursion.
 * 3) This type of recursion allows for more flexible and customizable recursive algorithms, as different parameters can influence the behavior of the recursive function.
 * 4) Example: The factorial function with an accumulator parameter in the tail recursive version provided earlier (factorialTail function).
 * ---> Functional Recursion: 
 * 1) Functional recursion refers to the use of recursion in functional programming languages, where functions are treated as first-class citizens and recursion is a fundamental technique for solving problems.
 * 2) In functional recursion, recursion is often used to express solutions in a declarative and concise manner, leveraging the principles of functional programming.
 * 3) Functional recursion often emphasizes immutability and avoids mutable state, making it well-suited for functional programming paradigms.
 * 4) Example: Recursively defining mathematical functions like factorial, Fibonacci sequence, etc., in functional programming languages like Haskell, Scheme, or Clojure.
 */
import java.util.Scanner;

public class SumofFirstNNumbers {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the input number: ");
        int n = scan.nextInt();

        System.out.print("The sum using parameterized recursion method is: ");
        calculateSum(n, 0);

        System.out.print("The sum using functional recursion method is: ");
        int sum = calculate(n);
        System.out.println(sum);

        scan.close();
    }

    //Using parameterized recursion.
    public static void calculateSum(int i, int sum) {
        if(i < 1) {
            System.out.println(sum);
            return;
        }

        calculateSum(i - 1, sum + i);

    }

    //Using functional recursion
    public static int calculate(int n) {
        if(n == 0) {
            return n;
        }

        return n + calculate(n - 1);
    }
}
