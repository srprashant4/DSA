/**
 * Problem: Reverse Only Letters
 * Approach: Use Two-Pointers
 * Given a string s, reverse the string according to the following rules:
 * 1) All the characters that are not English letters remain in the same position.
 * 2) All the English letters (lowercase or uppercase) should be reversed.
 * 
 * Examples:
 * 1) Input: s = "ab-cd"
 * Output: "dc-ba"
 * 
 * 2) Input: s = "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 * 
 * 3) Input: s = "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 */
public class ReverseLetters {
    public static void main(String[] args) {
        ReverseLetters rl = new ReverseLetters();
        String str = "Test1ng-Leet=code-Q!";
        System.out.println(rl.reverseOnlyLetters(str));
    }

    public String reverseOnlyLetters(String s) {
        if(s.length() == 1) {
            return s;
        }
        
        char[] arr = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            if(!Character.isLetter(arr[left])) {
                left++;
                continue;
            }

            else if(!Character.isLetter(arr[right])) {
                right--;
                continue;
            }

            else {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }
        return new String(arr);
    }
}
