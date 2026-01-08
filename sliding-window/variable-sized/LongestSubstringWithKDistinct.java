import java.util.*;

/*
===========================================================
Problem: Longest Substring with At Most K Distinct Characters
===========================================================

Problem Statement:
Given a string s and an integer k, find the length of the longest
substring that contains at most k distinct characters.

Important Notes:
- A substring is a contiguous part of the string.
- The string is NOT circular.
- Characters are case-sensitive unless stated otherwise.
- Return only the length of the substring.

-----------------------------------------------------------
Examples:

Example 1:
Input:
s = "eceba", k = 2

Explanation:
"ece" contains only {e, c} → 2 distinct characters

Output:
3

-----------------------------------------------------------

Example 2:
Input:
s = "aa", k = 1

Output:
2

-----------------------------------------------------------

Example 3:
Input:
s = "abc", k = 1

Output:
1

-----------------------------------------------------------
Approach:
- Use the Variable Size Sliding Window technique.
- Maintain a frequency map to track character counts.
- Expand the window by moving the right pointer.
- If the number of distinct characters exceeds k,
  shrink the window from the left until it becomes valid.
- Update the maximum window length only when valid.

Key Insight:
The number of distinct characters in the window is always
equal to the size of the frequency map.

-----------------------------------------------------------
Time Complexity: O(n)
Space Complexity: O(k)

Pattern:
- Sliding Window (Variable Size)
- Two Pointers
- Frequency Map

===========================================================
*/
public class LongestSubstringWithKDistinct {
    public static void main(String[] args) {
        LongestSubstringWithKDistinct ld = new LongestSubstringWithKDistinct();
        String str = "aabc";
        int k = 2;
        System.out.println(ld.longestSubstringWithKDistinct(str, k));
    }

    public int longestSubstringWithKDistinct(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int result = 0;
        int left = 0;

        for(int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);

            // One-liner rule to remember forever: Maps track counts, not positions. So we decrement counts — not remove blindly.
            while(freqMap.size() > k) {
                char leftChar = s.charAt(left);
                if(freqMap.containsKey(leftChar)) {
                    freqMap.put(leftChar, freqMap.getOrDefault(leftChar, 0) - 1);
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
