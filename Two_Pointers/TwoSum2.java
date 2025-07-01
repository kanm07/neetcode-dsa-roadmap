/*
Approach:
1. Use a two-pointer technique since the array is sorted.
2. Start one pointer at the beginning (left) and one at the end (right).
3. Move the pointers inward based on the sum comparison with the target.
4. When the correct pair is found, return their 1-based indices.

Time Complexity: O(n), where n is the length of the array.
Space Complexity: O(1), using constant extra space.
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                break;
            }
        }
        return new int[] {left + 1, right + 1};
    }
}
