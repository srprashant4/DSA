/**
 * Leetcode: 1004. Max Consecutive Ones III
 * Problem Statement:
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 * 
 * Example 1:
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 * 
 * Example 2:
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 * Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        MaxConsecutiveOnes max = new MaxConsecutiveOnes();
        System.out.println(max.longestOnes(nums, k));
    }

    public int longestOnes(int[] nums, int k) {
        int result = 0;
        int freq = 0;
        int left = 0;
        int maxFreq = 0;

        for(int right = 0; right < nums.length; right++) {
            if(nums[right] == 1) {
                freq++;
            }

            maxFreq = Math.max(maxFreq, freq);

            while((right - left + 1) - maxFreq > k) {
                if(nums[left] == 1) {
                    freq--;
                }
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
