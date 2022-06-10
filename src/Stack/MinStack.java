package Stack;

import java.util.Stack;

/**
 * @author make
 */
public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);

        if (minStack.isEmpty() || x < minStack.peek()) {
            minStack.push(x);
        } else {
            minStack.push(minStack.peek());
        }

    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
