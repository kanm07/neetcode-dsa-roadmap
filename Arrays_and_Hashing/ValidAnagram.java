/*
Approach:
- Use a HashMap to count the frequency of each character in the first string `s`.
- Iterate through the second string `t`, decrementing the corresponding character counts.
- If a character in `t` doesn't exist in the map or its count goes below zero, return false.
- If all characters are matched correctly, return true.

Time Complexity: O(n)
Space Complexity: O(1) — assuming only lowercase English letters (fixed character set)
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        // Early exit if lengths differ
        if(s.length() != t.length()) {
            return false;
        }

        // Count character frequencies in the first string
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Subtract frequencies using the second string
        for(char c : t.toCharArray()) {
            if(!map.containsKey(c)) {
                return false;
            }
            map.put(c, map.get(c) - 1);
            if(map.get(c) < 0) {
                return false;
            }
        }

        return true;
    }
}
