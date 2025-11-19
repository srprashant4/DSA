/**
 * Problem:
 * Given an integer n, return the sum of its digits using recursion.
 * 
 * Examples:
 * 1) Input: n = 1234
 * Output: 10
 * Explanation: 1 + 2 + 3 + 4 = 10
 * 
 * 2) Input: n = 9
 * Output: 9
 */
public class SumOfDigits {
    public static void main(String[] args) {
        SumOfDigits sumOfDigits = new SumOfDigits();
        int n = 12345;
        System.out.println(sumOfDigits.getDigitSum(n));
    }

    public int getDigitSum(int n) {

        // Base Case.
        if(n < 10) {
            return n;
        }

        return (n % 10) + getDigitSum(n / 10);
    }
}
