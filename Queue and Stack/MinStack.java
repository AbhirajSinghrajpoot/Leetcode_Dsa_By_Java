import java.util.*;

public class MinStack {

    static Stack<Integer> stack = new Stack<>();
    static Stack<Integer> minStack = new Stack<>();

    public static void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(val, minStack.peek()));
        }
    }

    public static void pop() {
        stack.pop();
        minStack.pop();
    }

    public static int top() {
        return stack.peek();
    }

    public static int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        push(-2);
        push(0);
        push(-3);
        System.out.println(getMin()); // -3
        pop();
        System.out.println(top());    // 0
        System.out.println(getMin()); // -2
    }
}
