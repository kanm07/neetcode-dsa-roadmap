/*
Approach:
- Use a sliding window to track the longest substring that can be turned into all the same letter
  by changing at most k characters.
- Maintain a frequency array to count characters in the window.
- Track the count of the most frequent character (`maxcount`) in the current window.
- If (window size - maxcount) > k, it means we need to shrink the window from the left.
- Update the max length during each valid window.

Time Complexity: O(n)
Space Complexity: O(1) since the alphabet size is fixed (26 letters)
*/

class Solution {
    public int characterReplacement(String s, int k) {
        if (s.length() == 0) return 0;

        int left = 0, maxcount = 0, maxlength = 0;
        int[] freq = new int[26];

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            maxcount = Math.max(maxcount, freq[s.charAt(right) - 'A']);

            if ((right - left + 1) - maxcount > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxlength = Math.max(maxlength, right - left + 1);
        }

        return maxlength;
    }
}
