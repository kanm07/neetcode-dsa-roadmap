/*
Approach:
- Use a sliding window with a HashSet to track unique characters.
- Expand the window by moving `right`, and add characters to the set.
- If a duplicate is found, shrink the window from the left until the duplicate is removed.
- Update the maximum window size during each valid window expansion.

Time Complexity: O(n)
Space Complexity: O(k) where k is the character set size (e.g., 128 for ASCII)
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        int left = 0, right = 1, max_length = 0;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));

        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                max_length = Math.max(max_length, set.size());
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return Math.max(max_length, set.size());
    }
}
