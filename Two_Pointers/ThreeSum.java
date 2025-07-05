/*
Approach:
1. Sort the array.
2. Fix one index and use two pointers to find pairs that sum to zero with it.
3. Skip duplicates to avoid repeating triplets.

Time Complexity: O(n^2)
Space Complexity: O(1) (excluding result list)
*/

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicate fixed values

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) left++;  // skip dup left
                    while (left < right && nums[right] == nums[right - 1]) right--; // skip dup right

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;  // need a bigger sum
                } else {
                    right--; // need a smaller sum
                }
            }
        }

        return res;
    }
}
