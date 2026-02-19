/**
 * Lower Bound Template:
 * - Core Idea: The first index i such that arr[i] >= target
 * - We are searching for first True in a monotonic condition.
 * 
 * - Returns the index of the first element that is greater than or equal to the target.
 * - If all elements are less than the target, it returns the length of the array (insertion position).
 * 
 * - Condition: arr[mid] >= target
 * - If true → go left
 * - If false → go right
 * 
 * - We are using a half-open interval [left, right) to maintain the search space.
 * - The loop continues until left == right, at which point left is the insertion position for the target.
 * 
 * Example:
 * Input: arr = [1, 2, 3, 4, 5, 6, 7], target = 6
 * Output: 5 (index of the first element that is >= 6)
 * 
 * Input: arr = [1, 2, 3, 4, 5, 6, 7], target = 8
 * Output: 7 (insertion position for 8)
 */
public class LowerBoundTemplate {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        int target = 6;
        LowerBoundTemplate lb = new LowerBoundTemplate();
        System.out.println(lb.lowerBound(arr, target));
    }

    public int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length; // notice: right is exclusive

        while(left < right) {
            int mid = left + (right - left) / 2;

            if(arr[mid] >= target) {
                right = mid; // potential answer, move left
            }
            else {
                left = mid + 1; // discard left half
            }
        }
        return left; // insertion position
    }
}
