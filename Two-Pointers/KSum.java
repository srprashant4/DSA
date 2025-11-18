/**
 * K-Sum problem to solve all the cases (k = 1, 2, 3 ...) using recursion.
 * 
 * Line-by-line explanantion:
 * 1) Arrays.sort(nums);
 * Sorting is required because:
 *  a) two-pointer 2-sum requires sorted input, and
 *  b) duplicates cluster together so we can skip them easily.
 * 
 * 2) kSumHelper(nums, target, k, start) parameters explained
 *  a) nums — sorted array
 *  b) target — the sum we want to make (we use long inside to avoid overflow)
 *  c) k — how many numbers we need to pick (2,3,4,...)
 *  d) start — index where we may pick the next element (ensures we only use elements to the right and avoid reuse)
 * 
 * 3) Base case k == 2 (two-sum)
 *  Use the classic two-pointer algorithm (O(n)) to return all unique pairs in nums[start..end] that sum to target. Duplicate skipping inside the 2-sum loop prevents repeated pairs.
 * 
 * 4) Recursive case (k > 2)
 *  a) We iterate i from start to nums.length - (k-1) because we need at least k-1 elements after i.
 *  b) if (i > start && nums[i] == nums[i - 1]) continue; — skip duplicate choices for the current position so we don’t produce duplicate results.
 *  c) Pruning: compute smallest and largest possible sums if we pick nums[i] and then the smallest/largest possible (k-1) others. If the current target falls outside [smallest, largest]:
 *      - target < smallest → since array is sorted, any later i will be ≥ current i, so smallest will only grow → break loop.
 *      - target > largest → current i cannot yield a solution, but maybe later i (larger nums[i]) can → continue.
 * 
 *  d) Recurse: call kSumHelper(nums, target - nums[i], k - 1, i + 1). This returns all (k-1)-tuples (sorted) summing to target - nums[i]. For each returned subset, prepend nums[i] and add to result.
 * 
 * 5) Return result.
 * 
 * 
 * Complexity and memory:
 * 1) Time: roughly O(n^{k-1}) in the worst case (k fixed small). For k=2 → O(n), k=3 → O(n²), k=4 → O(n³), etc. The pruning sometimes reduces this in practice.
 * 2) Space: recursion depth = ≈k (O(k) extra), plus result storage.
 * 
 * 
 * Call Tree:
 * k=4
 * ├── pick -2 → call k=3 target=2
 * │     ├── pick -1 → call k=2 target=3
 * │     │     └── pair (1,2)
 * │     ├── pick 0 → no pairs
 * │     └── pick 1 → no pairs
 * │
 * │→ builds [-2,-1,1,2]
 * │
 * ├── pick -1 → no 3-sum for target=1
 * └── pick 0 → not enough numbers
 * 
 * 
 * K-Sum recursion:
 * 4-Sum → pick -2 → now solve 3-Sum
 * 3-Sum → pick -1 → now solve 2-Sum
 * 2-Sum → find (1,2)
 */
import java.util.*;

public class KSum {

    public static void main(String[] args) {
        KSum ksum = new KSum();
        // Final Answer: [-2, -1, 1, 2]
        System.out.println(ksum.kSumUsingRecursion(new int[]{-2, -1, 0, 1, 2}, 0, 4));
    }

    public List<List<Integer>> kSumUsingRecursion(int[] nums, int target, int k) {
        Arrays.sort(nums);
        return kSumHelper(nums, (long) target, k, 0);
    }

    private List<List<Integer>> kSumHelper(int[] nums, long target, int k, int start) {
        List<List<Integer>> result = new ArrayList<>();

        // Base case: 2-sum using two pointers
        if (k == 2) {
            int left = start, right = nums.length - 1;
            while (left < right) {
                long sum = (long) nums[left] + nums[right];
                if (sum == target) {
                    result.add(Arrays.asList(nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                    while (left < right && nums[right] == nums[right + 1])
                        right--;
                } else if (sum < target)
                    left++;
                else
                    right--;
            }
            return result;
        }

        // Recursive case: reduce k by picking one element and recursing
        for (int i = start; i < nums.length - (k - 1); i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue; // skip duplicate first elements

            // Prune: compute smallest & largest possible sums with current i
            long smallest = (long) nums[i] + (long) nums[i + 1] * (k - 1);
            long largest = (long) nums[i] + (long) nums[nums.length - 1] * (k - 1);
            if (target < smallest)
                break; // even the smallest possible > target → no solutions further
            if (target > largest)
                continue; // even the largest possible < target → skip this i

            // Recurse for k-1 sum on the remainder
            for (List<Integer> subset : kSumHelper(nums, target - nums[i], k - 1, i + 1)) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.addAll(subset);
                result.add(list);
            }
        }

        return result;
    }
}
