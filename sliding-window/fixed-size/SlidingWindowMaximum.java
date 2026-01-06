import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Problem-4: Sliding Window Maximum
 * Problem Statement:
 * You are given:
 * - An integer array nums
 * - An integer k (window size)
 * For every contiguous subarray (window) of size k, return the maximum element in that window.
 * 
 * What does “sliding window” mean here?
 * The window:
 * - Has fixed size = k
 * - Moves one step at a time from left → right
 * 
 * Example:
 * nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output:
 * [3,3,5,5,6,7]
 * 
 * Why brute force fails:
 * For each window → scan k elements
 * Time = O(n × k) ❌
 * We need O(n)
 * So we need to reuse information from previous windows.
 * 
 * Interview Pattern Recognition:
 * Whenever you see:
 * - Fixed window
 * - Max / Min / Extreme value
 * Think: “Monotonic Deque”
 * 
 * Deque rules (final form)
 * Rule-1: Monotonic Decreasing
 * - Deque always stores elements in decreasing order
 * - Back → smallest
 * - Front → largest (current max)
 * Rule-2: Cleanup on Insert
 * - When a new element arrives: Remove from back while new element is greater
 * - This is because smaller elements will never become maximum again.
 * Rule 3: Cleanup on Slide
 * - When window moves: Remove from front if it goes out of window
 * - This is because it no longer belongs to the window.
 * 
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int window = 3;
        SlidingWindowMaximum sm = new SlidingWindowMaximum();
        System.out.println(Arrays.toString(sm.maxSlidingWindow(nums, window)));
    }

    private int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;

        for (int i = 0; i < n; i++) {

            // Remove indices outside the window
            // Remove element that just slid out of the window
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }

            // Remove smaller elements from back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current index
            deque.offerLast(i);

            // Store result when window is ready
            if (i >= k - 1) {
                // Front always holds max
                result[index++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

}
