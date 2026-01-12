import java.util.*;

/*
Problem:
---------
You are given a string s consisting of only uppercase English letters ('A' to 'Z')
and an integer k.

You can replace at most k characters in the string with any other uppercase letter.
Return the length of the longest substring that can be obtained where all characters
in the substring are the same after at most k replacements.

Important:
-----------
- A substring must be CONTIGUOUS.
- Replacements can be done anywhere inside the chosen substring.
- We are NOT required to return the substring, only its maximum length.

Examples:
---------
Example 1:
Input: s = "ABAB", k = 2
Output: 4
Explanation:
Replace both 'A's with 'B' → "BBBB" (length = 4)

Example 2:
Input: s = "AABABBA", k = 1
Output: 4
Explanation:
Longest valid substring is "AABA" or "ABBA".
In both cases, we replace 1 character to make all characters same.

Example 3:
Input: s = "ABCDE", k = 1
Output: 2
Explanation:
Any two consecutive characters can be made same with 1 replacement.

Key Observations:
-----------------
1. We use the Sliding Window (Variable Window) pattern.
2. In any window, only ONE character matters:
   → the character with the maximum frequency (maxFreq).
3. Number of replacements needed for a window =
   windowSize - maxFreq
4. If replacements needed > k, the window becomes INVALID and must be shrunk.
5. Since the string contains only uppercase letters, we can use a fixed int[26]
   frequency array instead of a HashMap (O(1) space).

Why maxFreq is NOT decreased when shrinking:
--------------------------------------------
- Even if maxFreq becomes outdated, it does NOT affect correctness.
- It may delay shrinking slightly, but the window size is still valid.
- This avoids recalculating max frequency and keeps the algorithm O(n).

Time Complexity:
----------------
O(n), where n = length of the string.
Each character is processed at most twice (once by right, once by left).

Space Complexity:
-----------------
O(1), because the frequency array size is fixed (26 characters).

Core Formula to Remember:
-------------------------
windowSize - maxFrequency <= k  → valid window
windowSize - maxFrequency > k   → shrink window
*/
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "AAAAFBA";
        int k = 1;

        LongestRepeatingCharacterReplacement lr = new LongestRepeatingCharacterReplacement();
        System.out.println(lr.characterReplacement(s, k));
    }

    public int characterReplacement(String s, int k) {
        int result = 0;
        int left = 0;
        int maxFreq = 0;
        int[] freqMap = new int[26];

        for(int right = 0; right < s.length(); right++) {
            int currentIndex = s.charAt(right) - 'A';
            freqMap[currentIndex]++;

            maxFreq = Math.max(maxFreq, freqMap[currentIndex]);

            while((right - left + 1) - maxFreq > k) {
                freqMap[s.charAt(left) - 'A']--;
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }

    /*Below is the solution that is less optimal because it uses hashmap. This problem can be solved using a frequency array[26]
    Since it is clearly mentioned that the characters will be strictly upper-case. */

    // public int characterReplacement(String s, int k) {
    //     int result = 0;
    //     int left = 0;
    //     int maxFreq = 0;
    //     Map<Character, Integer> freqMap = new HashMap<>();

    //     for(int right = 0; right < s.length(); right++) {
    //         char ch = s.charAt(right);
    //         freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);

    //         // track max frequency seen so far
    //         maxFreq = Math.max(maxFreq, freqMap.get(ch));

    //         // current window size = right - left + 1
    //         while((right - left + 1) - maxFreq > k) {
    //             char leftChar = s.charAt(left);
    //             if(freqMap.containsKey(leftChar)) {
    //                 freqMap.put(leftChar, freqMap.getOrDefault(leftChar, 0) - 1);
    //                 if(freqMap.get(leftChar) == 0) {
    //                     freqMap.remove(leftChar);
    //                 }
    //             }
    //             left++;
    //         }

    //         result = Math.max(result, right - left + 1);
    //     }

    //     return result;
    // }

}
