public class MaximumSumSubarray {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 5, 15, 1, 3, 2, 21};
        int windowSize = 5;
        MaximumSumSubarray ms = new MaximumSumSubarray();
        System.out.println(ms.maxSumSubarray(nums, windowSize));
    }
    
    public int maxSumSubarray(int[] nums, int k) {
        int left = 0;
        int sum = 0;
        int maxSum = 0;

        for(int right = 0; right < nums.length; right++) {
            sum = sum + nums[right];

            if(right - left + 1 == k) {
                maxSum = Math.max(maxSum, sum);
                sum = sum - nums[left];
                left++;
            }
        }

        return maxSum;
    }
}
