/**
 * Problem Statement:
 * You are given a string s. Your task is to determine whether the string is a palindrome, 
 * considering only alphanumeric characters (letters and digits), and ignoring case.
 * 
 * 
 * What is a Palindrome?
 * A palindrome is a sequence of characters that reads the same forward and backward.
 * 
 * 
 * Examples of palindromes:
 * racecar
 * madam
 * 1221
 * "A man, a plan, a canal: Panama" → becomes "amanaplanacanalpanama" → same forward and backward
 * 
 * 
 * Examples that are not palindromes:
 * hello
 * abc
 * race a car
 * 
 * 
 * Key Requirements:
 * You must ignore:
 * spaces 
 * commas
 * punctuation
 * special characters
 * You must compare characters case-insensitively
 * Only consider letters (a–z, A–Z) and digits (0–9)
 * 
 * 
 * Constraints:
 * 1 <= s.length <= 2 * 10^5
 * Must run in O(n) time
 * Must use O(1) extra space
 * 
 * 
 * Requirements:
 * Use two pointers (left and right)
 * Do not build a new string or use extra memory (unless small, acceptable)
 * Must handle all edge cases above
 * 
 * 
 * Examples:
 * 1) Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: After removing all non-alphanumeric characters, s becomes "amanaplanacanalpanama", which is a palindrome.
 * 
 * 2) Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not the same backward.
 * 
 * 3) Input: s = " "
 * Output: true
 * Explanation: An empty or whitespace-only string is considered a palindrome.
 * 
 * 4) Input: s = "0P"
 * Output: false
 * Explanation: "0p" reversed is "p0"
 */
class Palin {
  public static void main(String[] args) {
    Palin palin = new Palin();
    String s = "A man, a plan, a canal: Panama";
    System.out.println(palin.isPalindrome(s));
  }
  
  public boolean isPalindrome(String s) {
      int left = 0;
      int right = s.length() - 1;
      
      while(left < right) {
          
          if(!Character.isLetterOrDigit(s.charAt(left))) {
              left++;
              continue;
          }
          
          if(!Character.isLetterOrDigit(s.charAt(right))) {
              right--;
              continue;
          }
          
          if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
            return false;
          }
            
        
        left++;
        right--;
      }
      return true;
  }
}