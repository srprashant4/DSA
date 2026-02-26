/**
 * 875. Koko Eating Bananas
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will 
 * come back in h hours.
 * 
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile.
 * If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during that hour.
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 * 
 * Intuition:
 * - Range of possible eating speeds: [1, max(piles)]
 * - We can use binary search to find the minimum eating speed that allows Koko to eat all the bananas within the given number of hours.
 * - The condition to check is whether Koko can eat all the bananas within the given number of hours with a certain eating speed.
 * - If Koko can eat with the current speed, we try to find a smaller speed (move left).
 * - If Koko cannot eat with the current speed, we need to increase it (move right).
 * - The minimum eating speed must be at least 1 (since Koko has to eat at least one banana per hour).
 * - The maximum eating speed would be the maximum number of bananas in any pile (if Koko eats the largest pile in one hour).
 * 
 * Example:
 * Input: piles = [3,6,7,11], h = 8
 * Output: 4
 * 
 * This pattern appears in:
 * - Minimum ship capacity (Ship Packages Within Ddays)
 * - Minimum days to make bouquets
 * - Allocate books
 * - Split array largest sum
 * - Aggressive cows
 * - Load balancing
 * 
 * Time Complexity: O(n log m) where n is the number of piles and m is the range of eating speeds (max(piles) - 1).
 * Space Complexity: O(1) for the binary search, O(n) for the input array.
 */
public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = new int[]{3,6,7,11};
        int h = 8;
        KokoEatingBananas kb = new KokoEatingBananas();
        System.out.println(kb.minEatingSpeed(piles, h));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for(int a : piles) {
            right  = Math.max(right, a);
        }

        while(left < right) {
            int mid = left + (right - left) / 2;
            
            if(canEat(piles, h, mid)) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean canEat(int[] piles, int h, int speed) {
        int hours = 0;

        for(int pile : piles) {
            hours += (pile + speed - 1) / speed; // Equivalent to Math.ceil(pile / speed)
        }
        
        return hours <= h;
    }
}
