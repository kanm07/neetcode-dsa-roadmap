/*
Approach:
1. Binary search over rows to find one where target could be present
   (i.e., target lies between matrix[row][0] and matrix[row][n - 1]).
2. If no such row is found (top > bottom), return false.
3. Perform binary search within that row.

Time Complexity: O(log m + log n)
Space Complexity: O(1)
*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m - 1;

        // Binary search to find the correct row
        while (top <= bottom) {
            int mid = top + (bottom - top) / 2;
            if (matrix[mid][0] <= target && matrix[mid][n - 1] >= target) {
                // Binary search within the found row
                int low = 0, high = n - 1;
                while (low <= high) {
                    int midCol = low + (high - low) / 2;
                    if (matrix[mid][midCol] == target) return true;
                    else if (matrix[mid][midCol] < target) low = midCol + 1;
                    else high = midCol - 1;
                }
                return false; // Target not found in the row
            } else if (matrix[mid][0] > target) {
                bottom = mid - 1;
            } else {
                top = mid + 1;
            }
        }

        return false; // No suitable row found
    }
}
