import java.util.Arrays;

/**
 * Aggressive Cows
 * Problem Description: 
 * ----------------
 * You are given an array of integers stalls where stalls[i] represents the position of the ith stall.
 * You are also given an integer k which represents the number of cows. You need to assign cows to the stalls such that the 
 * minimum distance between any two cows is as large as possible. Return the largest minimum distance.
 * 
 * Important Constraints:
 * ----------------------
 * 1. The number of cows (k) is less than or equal to the number of stalls.
 * 2. The positions of the stalls are distinct.
 * 
 * Intuition:
 * ---------
 * This is a classic "Binary Search on Answer" problem. We want to maximize the minimum distance between any two cows, 
 * which can be reframed as:
 *    "What is the largest minimum distance (X) such that we can place k cows in the stalls?"
 * 
 * Search Space:
 * -------------
 * The answer must lie between:
 *   left  = 1                          // Minimum possible distance (at least 1 unit apart)
 *   right = max(stalls) - min(stalls)  // Maximum possible distance (the range of stall positions)
 * We binary search in the range [left, right].
 * 
 * For a candidate value mid:
 *  - Try to greedily place cows in the stalls such that the minimum distance between any two cows is at least mid.
 *  - Count how many cows can be placed with this minimum distance.
 *  - If cows placed >= k → mid is valid (try larger value)
 *  - Else → mid is too large (decrease it)
 * 
 * Since the feasibility function is monotonic:
 *  If mid works, any smaller value will also work. Therefore, we find the largest valid mid using binary search.
 * 
 * Example:
 * --------
 * stalls = [1, 2, 4, 8, 9]
 * k = 3
 * Possible placements:
 * - Place cows at positions [1, 4, 8] → minimum distance = 3
 * - Place cows at positions [1, 4, 9] → minimum distance = 3
 * - Place cows at positions [1, 2, 4] → minimum distance = 1
 * - Place cows at positions [1, 2, 8] → minimum distance = 1
 * - Place cows at positions [1, 2, 9] → minimum distance = 1
 * - Place cows at positions [2, 4, 8] → minimum distance = 2
 * - Place cows at positions [2, 4, 9] → minimum distance = 2
 * - Place cows at positions [4, 8, 9] → minimum distance = 1
 * Output: 3
 * 
 * Time Complexity:
 * ----------------
 * Let n be the number of stalls and m be the search space for distance (max(stalls) - min(stalls)).
 * The time complexity is O(n log m) because for each candidate distance (log m), we check the feasibility by iterating 
 * through the stalls (O(n)).
 * 
 * Space Complexity:
 * ----------------
 * O(1) - We use constant extra space for variables.
 */
public class AggressiveCows {
    public static void main(String[] args) {
        int[] stalls = new int[]{1, 2, 4, 8, 9};
        int cows = 3;
        AggressiveCows ac = new AggressiveCows();
        System.out.println(ac.getMaxMinDistance(stalls, cows));
    }

    public int getMaxMinDistance(int[] stalls, int cows) {
        Arrays.sort(stalls);
        int answer = 0;
        int left = 1;
        int right = stalls[stalls.length - 1] - stalls[0];

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(canPlace(stalls, cows, mid)) {
                answer = mid;
                left = mid + 1; // Try for a larger distance
            }
            else {
                right = mid - 1;
            }
        }

        return answer;
    }

    public boolean canPlace(int[] stalls, int cows, int distance) {
        int count = 1;
        int lastPosition = stalls[0];

        for(int i = 1; i < stalls.length; i++) {
            if(stalls[i] - lastPosition >= distance) {
                count++;
                lastPosition = stalls[i];
            }

            if(count == cows) {
                return true;
            }
        }

        return false;
    }
}
