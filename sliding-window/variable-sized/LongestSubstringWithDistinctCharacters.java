import java.util.*;

/*
===========================================================
Problem: Longest Substring Without Repeating Characters
===========================================================

Problem Statement:
Given a string s, find the length of the longest substring
that contains no repeating characters.

Important Notes:
- A substring is a contiguous sequence of characters.
- The string is NOT circular.
- Characters are case-sensitive ('A' and 'a' are different).
- Return only the length of the substring, not the substring itself.

-----------------------------------------------------------
Examples:

Example 1:
Input:
s = "abcabcbb"

Explanation:
The longest substring without repeating characters is "abc".

Output:
3

-----------------------------------------------------------

Example 2:
Input:
s = "bbbbb"

Explanation:
The longest substring without repeating characters is "b".

Output:
1

-----------------------------------------------------------

Example 3:
Input:
s = "pwwkew"

Explanation:
The longest substring without repeating characters is "wke".

Output:
3

-----------------------------------------------------------
Approach:
- Use the Variable Size Sliding Window technique.
- Maintain a frequency map to track character counts in the window.
- Expand the window by moving the right pointer.
- If a duplicate character is found (frequency > 1),
  shrink the window from the left until the window becomes valid again.
- Update the maximum length whenever the window is valid.

Key Insight:
At any point, the window is valid if all characters in it
appear only once.

-----------------------------------------------------------
Time Complexity: O(n)
Space Complexity: O(min(n, charset))

Pattern:
- Sliding Window (Variable Size)
- Two Pointers
- Frequency Map

===========================================================
*/
public class LongestSubstringWithDistinctCharacters {
    public static void main(String[] args) {
        LongestSubstringWithDistinctCharacters ls = new LongestSubstringWithDistinctCharacters();
        String s = "aa";
        System.out.println(ls.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int left = 0;
        Map<Character, Integer> freqMap = new HashMap<>();

        for(int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);

            while(freqMap.get(ch) > 1) {
                char leftChar = s.charAt(left);
                if(freqMap.containsKey(leftChar)) {
                    freqMap.put(leftChar, freqMap.getOrDefault(ch, 0) - 1);
                    if(freqMap.get(leftChar) == 0) {
                        freqMap.remove(leftChar);
                    }
                }
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
