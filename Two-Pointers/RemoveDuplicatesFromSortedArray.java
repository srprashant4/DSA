/**
 * Problem: 26. Remove Duplicates from Sorted Array
 * Approach: Use Two-Pointers
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique
 * element appears only once. The relative order of the elements should be kept the same.
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be 
 * placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, 
 * then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 * 
 * Examples:
 * 1) Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively. It does not matter 
 * what you leave beyond the returned k (hence they are underscores).
 * 
 * 2) Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively. It does not matter
 * what you leave beyond the returned k (hence they are underscores).
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray rd = new RemoveDuplicatesFromSortedArray();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int k = rd.removeDuplicates(nums);
        System.out.println(k);
        for(int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
    
        public int removeDuplicates(int[] nums) {
        int left = 0;

        for(int right = 1; right < nums.length; right++) {
            if(nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
            } 
        }
        return left + 1;
    }
}
