/**
 * Problem: Reverse a String: Given a string s, return its reverse using recursion only.
 * 
 * Examples:
 * 1) Input: "abcd"
 * Output: "dcba"
 * 
 * 2) Input: "a"
 * Output: "a"
 * 
 * RULES:
 * 1) No loops allowed
 * 2) No extra libraries
 * 3) Only recursion
 */
public class ReverseString {
    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        String str = "abcde";
        System.out.println(rs.reverse(str, str.length() - 1));
    }

    public String reverse(String str, int index) {
        if(index < 0) {
            return "";
        }

        return str.charAt(index) + reverse(str, index - 1);
    }
}
