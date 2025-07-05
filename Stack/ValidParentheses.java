/*
Approach:
- Use a stack to track opening brackets.
- Push opening brackets onto the stack.
- For each closing bracket, check if the stack is empty or the top doesn't match the expected opening bracket.
- If so, return false.
- After processing all characters, the stack should be empty for the string to be valid.

Time Complexity: O(n), where n is the length of the string
Space Complexity: O(n), for the stack
*/

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                if ((c == ')' && stack.peek() != '(') || 
                    (c == '}' && stack.peek() != '{') || 
                    (c == ']' && stack.peek() != '[')) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
