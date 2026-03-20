import java.util.*;

public class StackUsingQueues {

    static Queue<Integer> q = new LinkedList<>();

    public static void push(int x) {
        q.add(x);
        int size = q.size();
        while (size > 1) {
            q.add(q.remove());
            size--;
        }
    }

    public static int pop() {
        return q.remove();
    }

    public static int top() {
        return q.peek();
    }

    public static boolean empty() {
        return q.isEmpty();
    }

    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        System.out.println(top());   // 3
        System.out.println(pop());   // 3
        System.out.println(top());   // 2
        System.out.println(empty()); // false
    }
}
