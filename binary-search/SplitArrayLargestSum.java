/**
 * LeetCode 410 – Split Array Largest Sum
 *
 * Problem:
 * --------
 * Given an integer array nums and an integer k, split the array into k non-empty
 * contiguous subarrays such that the largest sum among these subarrays is minimized.
 *
 * Return the minimized largest sum.
 *
 * Important Constraints:
 * ----------------------
 * 1. The array must be split into exactly k contiguous parts.
 * 2. Elements cannot be reordered.
 * 3. We are minimizing the maximum subarray sum among the k partitions.
 *
 * Intuition:
 * ----------
 * This is a classic "Binary Search on Answer" problem.
 *
 * Instead of directly choosing partition points, we reframe the problem as:
 *
 *     "What is the smallest possible maximum subarray sum (X)
 *      such that we can split the array into <= k subarrays?"
 *
 * Search Space:
 * -------------
 * The answer must lie between:
 *
 *     left  = max(nums)        // At minimum, one subarray must contain the largest element
 *     right = sum(nums)        // At maximum, we take the whole array as one subarray
 *
 * We binary search in the range [left, right].
 *
 * For a candidate value mid:
 *     - Try to greedily split the array such that no subarray exceeds mid.
 *     - Count how many subarrays are formed.
 *     - If subarrays <= k → mid is valid (try smaller value)
 *     - Else → mid is too small (increase it)
 *
 * Since the feasibility function is monotonic:
 *     If mid works, any larger value will also work.
 *
 * Therefore, we find the smallest valid mid using binary search.
 *
 * Example:
 * --------
 * nums = [7, 2, 5, 10, 8]
 * k = 2
 *
 * Possible splits:
 *
 * [7] | [2,5,10,8]      → largest sum = 25
 * [7,2] | [5,10,8]      → largest sum = 23
 * [7,2,5] | [10,8]      → largest sum = 18   ← optimal
 * [7,2,5,10] | [8]      → largest sum = 24
 *
 * Output: 18
 *
 * Time Complexity:
 * ----------------
 * Let:
 *   n = nums.length
 *   S = sum(nums)
 *
 * Binary search runs in O(log S)
 * Each feasibility check runs in O(n)
 *
 * Total Time Complexity:
 *   O(n * log S)
 *
 * Space Complexity:
 * -----------------
 *   O(1)
 *
 * Key Pattern:
 * ------------
 * If a problem asks:
 *   - Minimize the maximum
 *   - Maximize the minimum
 *   - Find smallest X such that condition holds
 *
 * Think: Binary Search on Answer.
 */
public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = new int[]{7,2,5,10,8};
        int k = 2;

        SplitArrayLargestSum sl = new SplitArrayLargestSum();
        System.out.println(sl.splitArray(nums, k));
    }

    public int splitArray(int[] nums, int k){
        int left = 0;
        int right = 0;

        for(int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        while(left < right) {
            int mid = left + (right - left) / 2;

            if(canSplit(nums, k, mid)) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean canSplit(int[] nums, int k, int maxSum) {
        int subArrays = 1;
        int currentSum = 0;

        for(int num : nums) {
            if(currentSum + num > maxSum) {
                subArrays++;
                currentSum = 0;
            }
            currentSum += num;
        }

        return subArrays <= k;
    }
}
