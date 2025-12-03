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
