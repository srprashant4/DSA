/**
 * Two Sum II: Input Array Is Sorted (Medium)
 * Problem Statement:
 * You are given a 1-indexed, sorted array of integers numbers (sorted in non-decreasing order) and an integer target.
 * Find two numbers such that they add up to the target and return their indices (1-indexed).
 * If such a pair exists, return: [newIndex1, newIndex2]
 * 
 * 
 * The required output must satisfy:
 * 1 ≤ index1 < index2 ≤ numbers.length
 * Exactly one valid answer exists (as per problem guarantee)
 * 
 * 
 * Why This Problem Matters:
 * This is the canonical two-pointer problem for sorted arrays. The logic you learn here directly applies to:
 * Pair sum problems
 * Matching problems
 * Range shrinking
 * Triplet sum (3Sum uses this as a subroutine)
 * Minimizing differences
 * Closest pair
 * We ultimately reduce the time from O(n^2) to O(n) using two-pointer approach.
 * 
 * 
 * Example Test Cases:
 * 1) Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: 2 + 7 = 9
 * 
 * 2) Input: numbers = [2,3,4], target = 6
 * Output: [1,3]
 * Explanation: 2 + 4 = 6
 * 
 * 3) Input: numbers = [-1,0], target = -1
 * Output: [1,2]
 * 
 * 
 * Constraints:
 * 2 <= numbers.length <= 3 * 10^4
 * -1000 <= numbers[i] <= 1000
 * Array is sorted, and there is exactly one valid solution.
 * 
 * 
 * Common Pitfalls:
 * Missing 1-indexed return requirement
 * Trying to use HashMap (but problem says O(1) extra space)
 * Moving wrong pointer
 * Off-by-one errors
 * 
 * 
 * Requirements:
 * Must use two pointers, not hash maps
 * Time complexity: O(n)
 * Space complexity: O(1)
 * Return array of size 2 containing the 1-indexed positions
 * 
 */
import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] arr = new int[] { 2, 3, 4 };

        System.out.println(Arrays.toString(ts.twoSum(arr, 6)));
    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {

            int sum = numbers[left] + numbers[right];

            // If the sum is equal to target, return the 1-based indices.
            if(sum == target) {
                return new int[]{left + 1, right + 1};
            }

            // Sum is too small, increase the window.
            else if (sum < target) {
                left++;
            }

            // Sum is too big, shrink the window.
            else {
                right--;
            }
        }

        return new int[2];
    }
}
