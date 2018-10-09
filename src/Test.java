

import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;
import java.util.TreeSet;


public class Test {
    public static void main(String[] args) {
        //testStack();
        testSet();
    }

    public static void testStack() {
        MinStack stack = new MinStack();
        stack.push(3);
        stack.pop();
        stack.top();
    }

    public static void testSet() {
        int[] arr = {1,2,3,45,1,2,3,3};
        TreeSet<Integer> treeSet = new TreeSet<>();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            treeSet.add(arr[i]);
            hashSet.add(arr[i]);
        }

        System.out.println("TreeSet: ");
        Iterator<Integer> treeIter = treeSet.iterator();
        while (treeIter.hasNext()) {
            int i = treeIter.next();
            System.out.print(i + " ");
        }

        System.out.println("TreeSet: ");
        Iterator<Integer> hashIter = hashSet.iterator();
        while (hashIter.hasNext()) {
            int i = hashIter.next();
            System.out.print(i + " ");
        }

        System.out.println(treeSet.ceiling(40));
        System.out.println(treeSet.floor(40));
        System.out.println(treeSet.size());

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
