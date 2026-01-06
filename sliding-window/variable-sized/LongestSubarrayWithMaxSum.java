/*
===========================================================
Problem: Longest Subarray with Sum Less Than or Equal to K
===========================================================

Problem Statement:
Given an array of non-negative integers nums and an integer k,
find the length of the longest contiguous subarray whose sum
is less than or equal to k.

Important Notes:
- A subarray must be contiguous.
- The array is NOT circular.
- All elements are non-negative integers.
- Return the maximum length, not the subarray itself.

-----------------------------------------------------------
Examples:

Example 1:
Input:
nums = [2, 1, 5, 1, 3]
k = 5

Valid Subarrays:
[2, 1] -> sum = 3
[5]    -> sum = 5
[1, 3] -> sum = 4

Output:
2

-----------------------------------------------------------

Example 2:
Input:
nums = [1, 2, 1, 1, 1]
k = 3

Valid Subarrays:
[1, 2]     -> sum = 3
[1, 1, 1]  -> sum = 3

Output:
3

-----------------------------------------------------------

Example 3:
Input:
nums = [5, 1, 2, 3]
k = 4

Output:
0

-----------------------------------------------------------
Approach:
- Use the Variable Size Sliding Window technique.
- Maintain two pointers (left and right).
- Expand the window by moving right and adding nums[right] to sum.
- If sum exceeds k, shrink the window from the left until sum <= k.
- At every valid window, update the maximum length.

Key Insight:
This approach works ONLY because all numbers are non-negative.
Negative numbers break the sliding window invariant.

-----------------------------------------------------------

Key Invariant:
- After shrinking the window, the subarray between left and right is always valid
- In other words, inside the for loop, always make the window valid first by moving the left pointer, and only then compute the max sum.

-----------------------------------------------------------

Window Length Formula (Very Important):
- Do NOT track length manually by using a variable count.
- Always compute: right - left + 1, This avoids bugs and keeps logic clean.
-----------------------------------------------------------

Time Complexity: O(n)
Space Complexity: O(1)

Pattern:
- Sliding Window (Variable Size)
- Two Pointers
===========================================================
*/
public class LongestSubarrayWithMaxSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 1, 3, 1, 1, 3, 2};
        int k = 7;
        LongestSubarrayWithMaxSum ls = new LongestSubarrayWithMaxSum();
        System.out.println(ls.longestSubarrayWithSumAtMostK(nums, k));
    }

    public int longestSubarrayWithSumAtMostK(int[] nums, int k) {
        int left = 0;
        int sum = 0;
        int result = 0;

        for(int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while(sum > k) {
                sum -= nums[left];
                left++;
            }

            if(sum <= k) {
                result = Math.max(result, right - left + 1);
            }
        }

        return result;
    }
}
