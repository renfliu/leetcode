

import java.util.Stack;


public class Test {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(3);
        stack.pop();
        stack.top();
    }
}

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int x) {
        stack.push(x);
        int min = minStack.peek();
        if (x < min) {
            minStack.push(x);
        }else {
            minStack.push(min);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }

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
