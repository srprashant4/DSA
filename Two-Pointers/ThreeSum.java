/**
 * TWO POINTERS – PROBLEM #3: 3Sum (Medium)
 * (This expands your two-pointer skills from 2 elements to 3 elements.)
 * 
 * 
 * Given an integer array nums, return all unique triplets [a, b, c] such that:
 * a + b + c = 0
 * You must return unique triplets.
 * The order of the triplets or numbers inside them does not matter.
 * 
 * You CANNOT have duplicate results like:
 * [-1, 0, 1]
 * [-1, 0, 1]   // invalid duplicate
 * Because of duplicates in input, we need careful handling.
 * 
 * 
 * Constraints:
 * -10^5 <= nums[i] <= 10^5
 * Array size can be up to 10,000
 * Time complexity target: O(n²)
 * This is why two pointers is used.
 * 
 * 
 * Example Test Cases:
 * 1) nums = [-1, 0, 1, 2, -1, -4]
 * Output:
 * [[-1, -1, 2], [-1, 0, 1]]
 * Explanation: Many combinations exist, but only these two sum to 0 and are unique.
 * 
 * 2) nums = [0, 1, 1]
 * Output: []
 * Explanation: No 3 numbers sum to zero.
 * 
 * 3) nums = [0, 0, 0, 0]
 * [[0, 0, 0]]
 * Explanation: Even though many 0s exist, only one valid triplet is allowed.
 * 
 * 
 * Follow the typical pattern:
 * sort nums
 *   for each i:
 *      skip duplicates
 *        left = i+1
 *        right = n-1
 *        while left < right:
 *            check sum
 *            skip duplicates
 * 
 * 
 * THE CORE INTUITION (READ THIS TWICE):
 * When a triplet is found:
 * 
 * We MUST move both pointers: (because left and right have already participated in one triplet)
 * Then we MUST skip all duplicates: to avoid producing the same triplet again.
 * Because the array is sorted, all duplicates sit next to each other: So skipping duplicates is easy: just move the pointer forward/back until the number changes.
 * 
 * 
 * REAL-LIFE EXAMPLE:
 * Imagine your wallet.
 * You want to pick 3 coins whose total value is 0 rupees.
 * But coins can be:
 * -5 rupees (you owe this)
 * +1 rupee
 * +5 rupees
 * -1 rupee
 */
import java.util.*;

class ThreeSum {
    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        System.out.println(ts.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // Skip the duplicate elements on the left side.
                    while (left < right && nums[left] == nums[left - 1])
                        left++;

                    // Skip the duplicate elements on the right side.
                    while (left < right && nums[right] == nums[right + 1])
                        right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}