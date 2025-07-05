/*
Approach:
Use two pointers from both ends of the array. Track the maximum height seen so far from the left and right.
At each step, process the side with the smaller height since it's the limiting factor for water trapping.
Add the difference between the max height seen so far and the current height to the total water.

Time Complexity: O(n) – each index is visited at most once  
Space Complexity: O(1) – constant extra space used
*/

class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftmax = 0, rightmax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                leftmax = Math.max(leftmax, height[left]);
                water += leftmax - height[left];
                left++;
            } else {
                rightmax = Math.max(rightmax, height[right]);
                water += rightmax - height[right];
                right--;
            }
        }

        return water;
    }
}
