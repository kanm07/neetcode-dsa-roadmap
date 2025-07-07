/*
Approach:
- Use a stack to evaluate the Reverse Polish Notation expression.
- For each token:
    - If it's a number, push it onto the stack.
    - If it's an operator, pop the top two numbers, perform the operation, and push the result back.
- Return the final result from the stack.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (!"+-*/".contains(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                }
            }
        }

        return stack.pop();
    }
}
