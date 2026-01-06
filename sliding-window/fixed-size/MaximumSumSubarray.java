/**
 * Problem: Maximum Sum of a Subarray of Size K. (also known as “Fixed Window Maximum Sum”)
 * 
 * Problem Statement: Given an integer array nums and an integer k, find the maximum sum of any contiguous subarray of size k.
 * 
 * Example 1:
 * Input: nums = [2, 1, 5, 1, 3, 2], k = 3
 * Output: 9
 * 
 * Explanation:
 * Subarrays of size 3:
 * [2,1,5] → sum=8  
 * [1,5,1] → sum=7  
 * [5,1,3] → sum=9  (max)  
 * [1,3,2] → sum=6  
 * 
 * Example 2:
 * Input: nums = [4, 5, 6, 1, 2], k = 2
 * Output: 11
 * 
 * Explanation:
 * [5,6] → max
 */
public class MaximumSumSubarray {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 5, 15, 1, 3, 2, 21};
        int windowSize = 5;
        MaximumSumSubarray ms = new MaximumSumSubarray();
        System.out.println(ms.maxSumSubarray(nums, windowSize));
    }
    
    public int maxSumSubarray(int[] nums, int k) {
        int left = 0;
        int sum = 0;
        int maxSum = 0;

        for(int right = 0; right < nums.length; right++) {
            sum = sum + nums[right];

            if(right - left + 1 == k) {
                maxSum = Math.max(maxSum, sum);
                sum = sum - nums[left];
                left++;
            }
        }

        return maxSum;
    }
}
