/**
 * Problem: Count Occurrences of “hi” in a String.
 * Write a recursive function that counts how many times the substring "hi" appears without overlapping.
 * 
 * Examples:
 * 1) Input: "xhixhix"
 * Output: 2
 * 
 * 2) Input: ahibhi
 * Output: 2
 * 
 * 3) Input: hihi
 * Output: 2
 */
public class CountHi {
    public static void main(String[] args) {
        CountHi ch = new CountHi();
        String str = "xhixhix";
        System.out.println(ch.countHi(str));
    }

    public int countHi(String str) {
        if(str.length() < 2) {
            return 0;
        }

        if(str.startsWith("hi")) {
            return 1 + countHi(str.substring(2));
        }
        else {
            return countHi(str.substring(1));
        }
    }
}
