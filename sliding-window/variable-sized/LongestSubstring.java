import java.util.*;

public class LongestSubstring {
    public static void main(String[] args) {
        LongestSubstring ls = new LongestSubstring();
        String s = "abcddd";
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
