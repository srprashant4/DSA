import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMinimum {
    public static void main(String[] args) {
        SlidingWindowMinimum swm = new SlidingWindowMinimum();
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int window = 3;
        System.out.println(Arrays.toString(swm.minSlidingWindow(nums, window)));
    }

    private int[] minSlidingWindow(int[] nums, int window) {
        int[] result = new int[nums.length - window + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;

        for(int right = 0; right < nums.length; right++) {
            while(!deque.isEmpty() && nums[deque.peekLast()] > nums[right]) {
                deque.pollLast();
            }

            if(!deque.isEmpty() && deque.peekFirst() == right - window) {
                deque.pollFirst();
            }

            deque.offerLast(right);

            if(right >= window - 1) {
                result[index++] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
