/*
Approach:
Standard Binary Search:
1. Initialize two pointers: low = 0, high = nums.length - 1.
2. While low <= high:
   - Compute mid index.
   - If nums[mid] == target, return mid.
   - If nums[mid] > target, search left half by setting high = mid - 1.
   - Else, search right half by setting low = mid + 1.
3. If not found, return -1.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

public class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
