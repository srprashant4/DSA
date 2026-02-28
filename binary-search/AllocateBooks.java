/**
 * Allocate minimum number of pages
 * Key Pattern:
 * ------------
 * If a problem asks:
 *  - Minimize the maximum
 *  - Maximize the minimum
 *  - Find smallest X such that condition holds
 * Think: Binary Search on Answer.
 * 
 * Approach:
 * ---------
 * - If we can allocate with the current maximum pages, we try to find a smaller maximum (move left).
 * - If we cannot allocate with the current maximum pages, we need to increase it (move right).
 * - The minimum number of pages must be at least the maximum number of pages in a single book (since a student has to read at least one book).
 * - The maximum number of pages would be the sum of all pages (if one student reads all books).
 * 
 * Example:
 * Input: pages = [10, 20, 30, 40], students = 2
 * Output: 60
 * 
 * This pattern appears in:
 * - Minimum ship capacity (Ship Packages Within Ddays) 
 * - Minimum days to make bouquets
 * - Koko Eating Bananas
 * - Split array largest sum
 * - Aggressive cows
 * - Load balancing
 * 
 * Time Complexity: O(n log m) where n is the number of books and m is the range of maximum pages (sum(pages) - max(pages)).
 * Space Complexity: O(1) for the binary search, O(n) for the input array.
 */
public class AllocateBooks {
    public static void main(String[] args) {
        int[] pages = new int[]{10, 20, 30, 40};
        int students = 2;
        AllocateBooks ab = new AllocateBooks();
        System.out.println(ab.allocateBooks(pages, students));
    }

    public int allocateBooks(int[] pages, int students) {

        if(students > pages.length) return -1; // Not Possible

        int left = 0;
        int right = 0;

        for(int page : pages) {
            left = Math.max(left, page);
            right += page;
        }

        while(left < right) {
            int mid = left + (right - left) / 2;

            if(canAllocate(pages, students, mid)) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean canAllocate(int[] pages, int students, int maxPages) {
        int currentPages = 0;
        int studentsAssigned = 1;

        for(int page : pages) {
            if(currentPages + page > maxPages) {
                studentsAssigned++;
                currentPages = 0;
            }
            currentPages += page;
        }
        return studentsAssigned <= students;
    }
}
