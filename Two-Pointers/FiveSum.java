/**
 * 5-Sum Problem:
 * Given an integer array nums and an integer target, return all unique quintuplets [a, b, c, d, e] such that:
 * a + b + c + d + e == target
 * 
 * 
 * Requirements:
 * Output unique quintuplets.
 * Each quintuplet must be sorted internally.
 * The resulting list can be in any order.
 * Time complexity expected: O(n⁴) using 3 loops + 2 pointers (optimized version of K-Sum).
 * 
 * 
 * Example:
 * 1) Input: nums = [1, 0, -1, 0, -2, 2], target = 0
 * Output: [-2, -1, 0, 1, 2]
 */
import java.util.*;

public class FiveSum {
    public static void main(String[] args) {
        FiveSum fs = new FiveSum();
        int nums[] = new int[]{1, 0, -1, 0, -2, 2};
        System.out.println(fs.fiveSum(nums, 0));
    }

    public List<List<Integer>> fiveSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length - 4; i++) {

            if(i > 0 && nums[i] == nums[i - 1]) continue;

            for(int j = i + 1; j < nums.length - 3; j++) {

                if(j > i + 1 && nums[j] == nums[j - 1]) continue;

                for(int k = j + 1; k < nums.length - 2; k++) {
                    
                    if(k > j + 1 && nums[k] == nums[k - 1]) continue;

                    int left = k + 1;
                    int right = nums.length - 1;

                    while(left < right) {
                        long sum = (long)nums[i] + nums[j] + nums[k] + nums[left] + nums[right];

                        if(sum == target) {
                            result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[left], nums[right]));

                            left++;
                            right--;

                            while(left < right && nums[left] == nums[left - 1]) left++;
                            while(left < right && nums[right] == nums[right + 1]) right--;
                        }
                        else if(sum < target) {
                            left++;
                        }
                        else {
                            right--;
                        }
                    }
                }
            }
        }

        return result;
    }
}
