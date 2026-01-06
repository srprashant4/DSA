/**
 * Problem: Count Occurrences of Anagrams (Sliding Window + Frequency Map)
 * 
 * -------------------------------------------------------------------------------------------------------------------
 * Important Concept to be remembered:
 *  We can't track the first element added in the window in this case because we are dealing with hashmaps. Here we deal with frequencies
 * and not with the insertion orders, that is why, we decrement the occurence of the characters in the window map rather than directly
 * removing it. 
 * Example of why “direct removal” is wrong (with a concrete example):
 * str = "aabaab"
 * pat = "aab"
 * Pattern map: {a=2, b=1}
 * Window 1 → "aab", window = {a=2, b=1}, anagram found.
 * Now slide the window.
 * Character leaving window = 'a'
 * If you directly remove 'a':
 * window.remove('a')
 * window = {b=1}, which is wrong, because the actual window is:
 * "aba"
 * Correct map = {a=1, b=1}
 * You just erased a valid 'a' that still exists inside the window.
 * Correct logic: decrement first:
 * window.put('a', window.get('a') - 1);
 * Only when count reaches zero:
 * window.remove('a');
 * This guarantees that the map always reflects reality.
 * 
 * Why we don’t track “first added element”:
 * Because sliding window is defined by indices, not insertion order.
 * The element that leaves the window is: str[left]
 * But:
 * That character may appear multiple times
 * We don’t know which instance we’re removing
 * We only know the count must reduce by 1
 * 
 * Why this matters beyond anagrams
 * This exact rule applies to:
 * 1) Longest substring with K distinct chars
 * 2) Minimum window substring
 * 3) Substring with all unique chars
 * 4) Permutation in string
 * 5) Variable window problems
 * 
 * One-liner rule to remember forever: Maps track counts, not positions. So we decrement counts — not remove blindly.
 * --------------------------------------------------------------------------------------------------------------------
 * 
 * Given: 
 * A text string str and a pattern string pat.
 * 
 * Return:
 * The number of substrings of str that are anagrams of pat.
 * 
 * Example:
 * str = "cbaebabacd", pat = "abc"
 * Anagrams of "abc" in the string:
 * "cba" and "bac".
 * Output: 2
 * 
 * 
 * Why this problem is extremely important:
 * This problem teaches you:
 * 1) Fixed-size sliding window
 * 2) Frequency map usage
 * 3) Matching logic
 * 4) Counting windows correctly
 * 5) Multiple operations every window (add → remove → compare)
 * 
 */
import java.util.*;

public class CountOccurencesOfAnagrams {
    public static void main(String[] args) {
        CountOccurencesOfAnagrams cd = new CountOccurencesOfAnagrams();
        System.out.println(cd.countAnagrams("cbaebabacd", "abc"));
    }

    private int countAnagrams(String str, String pat) {
        int result = 0;
        int left = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(Character ch : pat.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        char[] charArr = str.toCharArray();
        for(int right = 0; right < charArr.length; right++) {

            char current = charArr[right];
            if(freqMap.containsKey(current)) {
                window.put(current, window.getOrDefault(current, 0) + 1);
            }
            if(right - left + 1 == pat.length()) {

                if(freqMap.equals(window)) {
                    result++;
                }

                // Important concept.
                // Read the description carefully to understand why we decrement the count rather than removing 
                // the element from the window completely.
                char leftChar = charArr[left];
                if(freqMap.containsKey(leftChar)) {
                    window.put(leftChar, window.get(leftChar) - 1);
                    if(window.get(leftChar) == 0) {
                        window.remove(leftChar);
                    }
                }
                left++;
            }
        }

        return result;
    }
}
