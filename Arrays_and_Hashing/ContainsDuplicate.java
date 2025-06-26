/*
Approach:
- Use a HashSet to track unique elements while iterating through the array.
- For each number, check if it already exists in the set.
- If it does, a duplicate is found — return true.
- Otherwise, add it to the set.
- If the loop completes without finding duplicates, return false.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i : nums) {
            if(hs.contains(i)) {
                return true;
            }
            hs.add(i);
        }
        return false;
    }
}
