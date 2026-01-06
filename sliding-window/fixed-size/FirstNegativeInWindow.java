/**
 * Problem: First Negative Number in Every Window of Size K.
 * 
 * Given an array nums and an integer k, return an array where each element is the first 
 * negative number in each window of size k. If a window does not contain any negative number, output 0.
 * 
 * 
 * Example-1:
 * Input: nums = [12, -1, -7, 8, 15, 30, 16, 28], k = 3
 * 
 * Windows of size 3:
 * [12, -1, -7] → first negative = -1  
 * [-1, -7,  8] → first negative = -1  
 * [-7,  8, 15] → first negative = -7  
 * [8, 15, 30] → no negative → 0  
 * [15, 30, 16] → no negative → 0  
 * [30, 16, 28] → no negative → 0
 * 
 * Output: [-1, -1, -7, 0, 0, 0]
 * 
 * 
 * Key Idea:
 * We maintain a sliding window, and also maintain a queue of negative numbers within that window.
 * Why a queue?
 * Because:
 * 1) The first element of the queue → first negative
 * 2) As we slide left forward, we remove negatives that slide out of the window
 * 3) When a new negative enters the window, we add it to the queue
 * This is classic fixed-window + auxiliary queue logic.
 * 
 * 
 * Sliding Window Pattern Here:
 * 1) Expand window with right
 * 2) If nums[right] is negative → add to queue
 * 3) When window size == k:
 *  -> result[index] = queue.isEmpty() ? 0 : queue.peek()
 *  -> before sliding left: if nums[left] == queue.peek(): remove it else left++
 * 4) Continue
 * 
 * Time complexity: O(n)
 * Because each element is added/removed from queue at most once.
 */
import java.util.*;

public class FirstNegativeInWindow {
    public static void main(String[] args) {
        FirstNegativeInWindow fn = new FirstNegativeInWindow();
        int[] nums = new int[]{-12, -1, -7, 8, 15, 30, 16, 28, -9};
        int window = 3;
        System.out.println(Arrays.toString(fn.firstNegativeInWindow(nums, window)));
    }

    public int[] firstNegativeInWindow(int[] nums, int k) {
        int left = 0;
        int index = 0;
        int[] result = new int[nums.length - k + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for(int right = 0; right < nums.length; right++) {
            if(nums[right] < 0) {
                queue.add(nums[right]);
            }

            if(right - left + 1 == k) {
                result[index] = queue.isEmpty() ? 0 : queue.peek();
                index++;

                if(!queue.isEmpty() && nums[left] == queue.peek()) {
                    queue.poll();
                }

                left++;
            }
        }

        return result;
    }
}
