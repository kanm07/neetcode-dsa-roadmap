/*
 * Approach:
 * - Use a HashSet to store all unique elements.
 * - For each number, only begin counting a sequence if (num - 1) is not in the set.
 * - Expand the sequence forward using a while loop and count its length.
 * - Track the maximum length encountered.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> temp = new HashSet<>();
        for (int i : nums) {
            temp.add(i);
        }

        int count = 0;
        for (int i : temp) {
            if (!temp.contains(i - 1)) {
                int del = 1;
                while (temp.contains(i + del)) {
                    del++;
                }
                count = Math.max(count, del);
            }
        }

        return count;
    }
}
