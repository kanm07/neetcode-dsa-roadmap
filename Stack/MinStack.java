/*
Approach:
We maintain two stacks:
1. stack - to store all values.
2. min_stack - to store the minimum value at each level of the stack.

When pushing a value, we also push the current minimum so far into min_stack.
When popping, we pop from both stacks to keep them in sync.
This ensures getMin() is always O(1) by returning min_stack.peek().

Time Complexity:
- push: O(1)
- pop: O(1)
- top: O(1)
- getMin: O(1)

Space Complexity:
- O(n) for maintaining the additional min_stack.
*/

class MinStack {
    Stack<Integer> stack, min_stack;

    public MinStack() {
        stack = new Stack<>();
        min_stack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (min_stack.isEmpty() || val <= min_stack.peek()) {
            min_stack.push(val);
        } else {
            min_stack.push(min_stack.peek());
        }
    }

    public void pop() {
        stack.pop();
        min_stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }
}
