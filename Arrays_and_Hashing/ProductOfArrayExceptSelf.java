/*
Approach:
- Use two passes to compute the product of all elements except self.
- First pass: compute prefix products (left side of each index).
- Second pass: compute suffix products (right side) and multiply with prefix.
- Avoids division and uses only O(1) extra space.

Time Complexity: O(n)
Space Complexity: O(1) (excluding the output array)
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }

        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }

        return result;
    }
}
