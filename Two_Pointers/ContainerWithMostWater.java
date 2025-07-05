/*
Approach:
- Use two pointers: one at the start, one at the end.
- Calculate the area formed by the two lines and update max.
- Move the pointer with the smaller height inward to try for a bigger area.
- Repeat until pointers meet.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int width = right - left;
            maxArea = Math.max(maxArea, minHeight * width);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
