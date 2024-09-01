/*
 * 1) This code will print the numbers from 1 to N. N is a user provided input.
 * 2) The code will be solved using two approaches, one with space complexity of O(N) and another with O(1).
 * 3) The space complexity of the first method 'linearSpace' is O(N). This approach uses the concept of simple recursion.
 * 4) The space complexity of the second method 'constantSpace' is O(1). This approach uses the concept of backtracking.
 * 5) The space complexity of the first approach is O(N) due to the recursive function calls, 
 * which consume stack space proportional to the depth of the recursion.
 * 6) this approach uses tail recursion, which allows the compiler to optimize the recursion into a loop, 
 * resulting in constant space complexity, O(1), as the space required for function call 
 * stack is constant regardless of the input size.
 */
import java.util.Scanner;

public class PrintNTo1 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the input number: ");
        int n = scan.nextInt();

        System.out.println("Using the simple recursion approach: ");
        linearSpace(n, n);

        System.out.println("Using the backtracking logic: ");
        constantSpace(1, n);

        scan.close();
    }

    public static void linearSpace(int i, int n) {
        if(i < 1) {
            return;
        }

        System.out.println(i);

        linearSpace(i - 1, n);
    }

    public static void constantSpace(int i, int n) {
        if(i > n) {
            return;
        }

        constantSpace(i + 1, n);

        System.out.println(i);
    }
}
