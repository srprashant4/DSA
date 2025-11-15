/**
 * 4Sum (K-Sum Pattern):
 * This problem generalizes everything you've learned so far from:
 * Two Sum (sorted version)
 * Three Sum
 * Duplicate skipping
 * Outer loops + inward two-pointers
 * Window expansion/contraction based on sum
 * Handling multiple nested duplicates
 * 
 * 
 * Problem Statement:
 * Given an array nums and an integer target, return all unique quadruplets [nums[a], nums[b], nums[c], nums[d]], such that:
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You must return unique combinations (no duplicates), and the quadruplets must be in non-decreasing order internally, and the final list can be in any order.
 * 
 * 
 * Input Examples:
 * 1) Input: nums = [1, 0, -1, 0, -2, 2], target = 0
 * Output: [[-2, -1, 1, 2], [-2,  0, 0, 2], [-1,  0, 0, 1]]
 * 
 * 2) Input: nums = [2, 2, 2, 2, 2], target = 8
 * Output: [[2, 2, 2, 2]]
 * 
 * 
 * Constraints:
 * You may assume the array length is ≥ 4.
 * Negative numbers allowed.
 * Duplicates exist.
 * Result must have no duplicate quadruplets.
 * 
 * 
 * Pseudocode:
 * i loop   (outer)
 *  j loop   (inner)
 *      left/right two-pointer to find 2Sum relative to remaining target
 * 
 * Also, you MUST apply duplicate-skips at THREE positions:
 * 1) skip duplicates for i
 * 2) skip duplicates for j
 * 3) skip duplicates for left and right (inside while loop)
 * 
 */
import java.util.*;

class FourSum {
    public static void main(String[] args) {
        FourSum fs = new FourSum();
        System.out.println(fs.fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {

            // Skip the duplicates in the outer loop.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {

                // Skip the duplicates in the inner loop.
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        left++;
                        right--;

                        // skip duplicates for left.
                        while(left < right && nums[left] == nums[left - 1]) left++;

                        // skip duplicates for right
                        while(left < right && nums[right] == nums[right + 1]) right--;
                    }
                    else if(sum > target) {
                        right--;
                    }
                    else {
                        left++;
                    }
                }

            }
        }

        return result;
    }
}