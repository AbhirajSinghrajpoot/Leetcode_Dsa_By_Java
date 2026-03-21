import java.util.*;

public class OnlineStockSpan {

    static Stack<int[]> stack = new Stack<>();

    public static int next(int price) {
        int span = 1;

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        stack.push(new int[]{price, span});
        return span;
    }

    public static void main(String[] args) {
        System.out.println(next(100)); // 1
        System.out.println(next(80));  // 1
        System.out.println(next(60));  // 1
        System.out.println(next(70));  // 2
        System.out.println(next(60));  // 1
        System.out.println(next(75));  // 4
        System.out.println(next(85));  // 6
    }
}
