/*
 * Approach:
 *   1. Count frequency of each element using a HashMap.
 *   2. Use bucket sort: Create an array of lists where index = frequency.
 *   3. Fill the buckets with numbers based on their frequency.
 *   4. Traverse buckets in reverse to collect the top k frequent elements.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Bucket array to store numbers by frequency
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        // Step 3: Fill buckets
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            bucket[freq].add(num);
        }

        // Step 4: Collect top k frequent elements from buckets
        int[] result = new int[k];
        int index = 0;
        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {
            for (int num : bucket[i]) {
                result[index++] = num;
                if (index == k) break;
            }
        }

        return result;
    }
}
