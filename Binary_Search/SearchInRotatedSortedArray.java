/*
Approach:
Use a modified binary search. At every step, determine which half of the array is sorted.
- If the left half is sorted (nums[low] <= nums[mid]):
    - Check if the target lies within that range. If yes, move high to mid - 1.
    - Otherwise, search in the right half.
- If the right half is sorted:
    - Check if the target lies within that range. If yes, move low to mid + 1.
    - Otherwise, search in the left half.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[low]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
