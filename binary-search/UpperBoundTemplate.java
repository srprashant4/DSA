/**
 * Problem: Given a sorted array of integers and a target value, find the index of the first element that is greater than the target value. 
 * If no such element exists, return the length of the array.
 * 
 * This is a classic problem that can be efficiently solved using the upper bound binary search template.
 * Upper Bound Template:
 * - Core Idea: The first index i such that arr[i] > target
 * - We are searching for first True in a monotonic condition.
 * - Returns the index of the first element that is greater than the target.
 * - If all elements are less than or equal to the target, it returns the length of the array (insertion position).
 * 
 * - Condition: arr[mid] <= target
 * - If true → go right
 * - If false → go left
 * - We are using a half-open interval [left, right) to maintain the search space.
 * - The loop continues until left == right, at which point left is the insertion position for the target.
 * - What this function returns depends on the presence and position of the target in the array:
 * | Scenario                | Return Value     |
 * | ----------------------- | ---------------- |
 * | Target exists           | First occurrence of element greater than target |
 * | Target missing          | Insertion index  |
 * | Target smaller than all | 0                |
 * | Target larger than all  | n                |
 * 
 * * Example:
 * Input: arr = [1, 2, 3, 4, 5, 6, 6, 7], target = 6
 * Output: 7 (index of the first element that is > 6)
 * 
 * Input: arr = [1, 2, 3, 4, 5, 6, 6, 7], target = 8
 * Output: 8 (insertion position for 8)
 */
public class UpperBoundTemplate {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,6,7};
        int target = 6;

        UpperBoundTemplate ut = new UpperBoundTemplate();
        System.out.println(ut.upperBound(arr, target));
    }

    public int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while(left < right) {
            int mid = left + (right - left) / 2;

            if(arr[mid] <= target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }
}
