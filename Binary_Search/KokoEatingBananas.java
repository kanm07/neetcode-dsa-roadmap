/*
Approach:
Use binary search on Koko's eating speed from 1 to the max pile size.
For each candidate speed, calculate the total hours needed.
If total hours exceed h, increase the speed; otherwise, try lower speed.
Ceiling division is used safely with int-only logic.

Time Complexity: O(n * log m), where n = number of piles, m = max pile size
Space Complexity: O(1)
*/

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0, result = Integer.MAX_VALUE;

        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = 0;

            for (int pile : piles) {
                count += (pile / mid) + (pile % mid == 0 ? 0 : 1);
                if (count > h) break;
            }

            if (count <= h) {
                result = Math.min(result, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }
}
