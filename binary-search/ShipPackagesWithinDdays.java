/**
 * Problem: Capacity To Ship Packages Within D Days.
 * You are given:
 * - an array of weights where weights[i] is the weight of the ith package, and
 * - an integer days, the number of days within which all the packages must be shipped.
 * 
 * You must ship packages in order.
 * Each day you load packages up to a certain capacity.
 * Find the minimum ship capacity so that all packages are shipped within days.
 * 
 * Intuition:
 * - Range of possible capacities: [ max(weights), sum(weights) ]
 * - We can use binary search to find the minimum capacity that allows us to ship all packages within the given number of days.
 * - The condition to check is whether we can ship all packages within the given number of days with a certain capacity.
 * - If we can ship with the current capacity, we try to find a smaller capacity (move left).
 * - If we cannot ship with the current capacity, we need to increase it (move right).
 * - The minimum capacity must be at least the maximum weight in the weights array (since we can't split packages).
 * - The maximum capacity would be the sum of all weights (if we ship everything in one day).
 * 
 * Example:
 * Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
 * Output: 15
 * Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
 * 1st day: 1, 2, 3, 4, 5
 * 2nd day: 6, 7
 * 3rd day: 8
 * 4th day: 9
 * 5th day: 10
 * 
 * This pattern appears in:
 * - Minimum eating speed (Koko Bananas)
 * - Minimum days to make bouquets
 * - Allocate books
 * - Split array largest sum
 * - Aggressive cows
 * - Load balancing
 * - Many DP optimizations
 * 
 * Time Complexity: O(n log m) where n is the number of weights and m is the range of capacities (sum(weights) - max(weights)).
 * Space Complexity: O(1) for the binary search, O(n) for the input array.
 */
public class ShipPackagesWithinDdays {
    public static void main(String[] args) {
        int[] weights = new int[]{3,2,2,4,1,4};
        int days = 3;

        ShipPackagesWithinDdays sp = new ShipPackagesWithinDdays();
        System.out.println(sp.shipWithinDays(weights, days));
    }

    public int shipWithinDays(int[] weights, int days) {
        int left = 0;  // Lower Bound
        int right = 0; // Upper Bound

        for(int w : weights) {
            left = Math.max(left, w); // Max of Weights
            right += w; // Sum of Weights
        }

        while(left < right) {
            int mid = left + (right - left) / 2;

            if(canShip(weights, days, mid)) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int daysUsed = 1;
        int currentLoad = 0;

        for(int w: weights) {
            if(currentLoad + w > capacity) {
                daysUsed++;
                currentLoad = 0;
            }
            currentLoad += w;
        }
        return daysUsed <= days;
    }
}
