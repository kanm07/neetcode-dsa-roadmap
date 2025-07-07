/*
Approach:
- Use a monotonic decreasing stack to keep track of indices of temperatures.
- For each temperature:
    - While the current temperature is greater than the temperature at the top of the stack:
        - Pop the index from the stack.
        - The current index is the next warmer day for that popped index.
        - Set result[poppedIndex] = currentIndex - poppedIndex
    - Push the current index onto the stack.
- At the end, any index left in the stack has no warmer day ahead, so it stays 0 by default.

Time Complexity: O(n) — each index is pushed and popped at most once
Space Complexity: O(n) — for the result array and the stack
*/

import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                res[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return res;
    }
}
