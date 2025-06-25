// This method checks if the given array contains any duplicate elements.
// It uses a HashSet to store unique numbers as it iterates through the array.
// If a number is already present in the set, it returns true (duplicate found).
// If no duplicates are found after the loop, it returns false.

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
