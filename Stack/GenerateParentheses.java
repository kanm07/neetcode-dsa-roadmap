/*
Approach:
- Use a stack to simulate DFS/backtracking to generate all valid parentheses.
- Each stack element is an Object[] holding:
    [current string, number of '(' used, number of ')' used]
- At each step:
    - Add '(' if open < n
    - Add ')' if close < open
- When open == n and close == n, the string is valid and added to the result.

Time Complexity: O(4^n / sqrt(n)) — number of valid sequences (Catalan number)
Space Complexity: O(4^n / sqrt(n)) — due to result list and stack space
*/

import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        Stack<Object[]> stack = new Stack<>();

        // Initial state: empty string with 0 open and 0 close parentheses
        stack.push(new Object[]{"", 0, 0});

        while (!stack.isEmpty()) {
            Object[] top = stack.pop();
            String curr = (String) top[0];
            int open = (int) top[1];
            int close = (int) top[2];

            // If a valid combination is formed, add to result
            if (open == n && close == n) {
                res.add(curr);
                continue;
            }

            // Add '(' if allowed
            if (open < n) {
                stack.push(new Object[]{curr + "(", open + 1, close});
            }

            // Add ')' if allowed
            if (close < open) {
                stack.push(new Object[]{curr + ")", open, close + 1});
            }
        }

        return res;
    }
}
