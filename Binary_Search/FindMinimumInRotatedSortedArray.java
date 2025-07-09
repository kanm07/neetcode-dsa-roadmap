/*
Approach:
Use binary search to locate the pivot point (smallest element) in the rotated sorted array.
At each step, compare nums[mid] with nums[high] to determine which half contains the minimum.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                // Minimum must be in the right half
                low = mid + 1;
            } else {
                // Minimum is in the left half (including mid)
                high = mid;
            }
        }

        return nums[low]; // or nums[high], since low == high
    }
}
