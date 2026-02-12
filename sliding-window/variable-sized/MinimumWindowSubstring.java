import java.util.*;

/**
 * Problem Statement: Given two strings s and t, return the minimum window in s which will contain all the characters in t. 
 * If there is no such window in s that covers all characters in t, return the empty string "". 
 * 
 * * * Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s. 
 * 
 * * * Example 1: 
 * * * Input: s = "ADOBECODEBANC", t = "ABC" 
 * * Output: "BANC" 
 * * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t. 
 * 
 * * Example 2: 
 * * * Input: s = "a", t = "a" 
 * * Output: "a" * Explanation: The entire string s is the minimum window. 
 * 
 * * Example 3: 
 * * * Input: s = "a", t = "aa" 
 * * Output: "" 
 * * Explanation: Both 'a's from t must be included in the window. Since the largest window of s only has one 'a', return empty string. 
 * 
 * * * Constraints: * * 1 <= s.length, t.length <= 10^5 * s and t consist of English letters. 
 * 
 * Important Invariants: 
 * * 1. The minimum window substring must contain all characters from t, including duplicates. 
 * * 2. If there are multiple minimum windows, return the one that appears first in s. 
 * * 3. The function should handle cases where t is longer than s, returning an empty string in such cases. 
 * * 4. The function should be case-sensitive, meaning 'A' and 'a' are considered different characters. 
 * * 5. The input strings may contain spaces and special characters, which should be treated as valid characters to match. 
 * * 6. The function should efficiently handle large input sizes, with a time complexity of O(n) where n is the length of s. 
 * 
 * 
 * High-Level Algorithm:
    left = 0
    formed = 0
    required = need.size()

    for right from 0 to s.length:

        add s[right] to window map

        if this character is in need
        and its frequency now equals need frequency:
            formed++

        while formed == required:
            update answer (min window)

            remove s[left] from window

            if removing causes freq < need freq:
                formed--

            left++
 * 
 * Algorithmic Approach: 
 * * * 1. Use a sliding window approach with two pointers (left and right) to traverse the string s. 
 * * * 2. Maintain a frequency map (need) for characters in t and a frequency map (window) for the current window in s. 
 * * * 3. Expand the right pointer to include characters in the window until all required characters are included (formed == required). 
 * * * 4. Once all required characters are included, try to shrink the window from the left to find the minimum window that still contains all required characters. 
 * * * 5. Update the minimum window length and starting index whenever a valid window is found. 
 * * * 6. Return the minimum window substring after traversing through s.
 * */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "AAABC";
        String t = "AABC";

        MinimumWindowSubstring mws = new MinimumWindowSubstring();
        System.out.println(mws.getMinimumWindow(s, t));
    }

    public String getMinimumWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) return "";

        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int required = need.size();
        int formed = 0;

        Map<Character, Integer> window = new HashMap<>();

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (need.containsKey(c) &&
                window.get(c).intValue() == need.get(c).intValue()) {
                formed++;
            }

            while (formed == required) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                if (need.containsKey(leftChar) &&
                    window.get(leftChar) < need.get(leftChar)) {
                    formed--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}
