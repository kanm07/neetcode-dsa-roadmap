/*
Approach:
- Use a HashMap to store each number and its index while iterating through the array.
- For every element `nums[i]`, calculate the complement as `target - nums[i]`.
- If the complement exists in the map, return the indices of the current number and the complement.
- This allows checking for a valid pair in constant time while iterating once through the array.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(mp.containsKey(complement)) {
                return new int[] {i, mp.get(complement)};
            }
            mp.put(nums[i], i);
        }
        return new int[] {};
    }
}
