/**
 * Problem: Count Occurrences of a Digit
 * Given a number n and a digit d, return how many times digit d appears in n using recursion.
 * 
 * Examples:
 * 1) Input: n = 122332, d = 2
 * Output: 3
 * 
 * 2) Input: n = 505050, d = 0
 * Output: 3
 */
public class CountDigitOccurence {
      public static void main(String[] args) {
    CountDigitOccurence cd = new CountDigitOccurence();
    int n = 122332;
    int target = 3;
    System.out.println(cd.countDigit(n, target));
  }
  
  public int countDigit(int n, int target) {
      n = Math.abs(n); // in case n is negative
      if(n < 10) {
          if(n == target) return 1;
          else return 0;
      }
      
      int count = 0;
      
      if(target == n % 10) count++;
      
      return count + countDigit(n / 10, target);   
  }
}
