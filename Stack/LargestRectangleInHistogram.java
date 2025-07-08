/*
Approach:
1. Add a trailing 0 to the input to flush out all remaining rectangles.
2. Use a monotonic increasing stack to store indices of the bars.
3. When the current bar is shorter than the top of the stack:
   - Pop the top index.
   - Use the corresponding height to compute the largest rectangle ending at this index.
   - Width is calculated based on the new top of the stack or from start if stack is empty.
4. Update the maximum area after each calculation.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxarea = 0;
        int[] arr = Arrays.copyOf(heights, heights.length + 1);
        arr[heights.length] = 0;
        
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                int height = arr[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxarea = Math.max(maxarea, height * width);
            }
            stack.push(i);
        }

        return maxarea;
    }
}
