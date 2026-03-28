import java.util.*;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < n; i++){

            // purana index nikalo
            if(!deque.isEmpty() && deque.peekFirst() < i - k + 1){
                deque.pollFirst();
            }

            // chota element nikalo
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }

            // current index add karo
            deque.addLast(i);

            // window complete hone ke baad max store karo
            if(i >= k - 1){
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        int[] result = maxSlidingWindow(nums, k);

        System.out.println(Arrays.toString(result));
        // Output: [3, 3, 5, 5, 6, 7]
    }
}


// ---

// **Run kaise karo:**
// ```
// javac SlidingWindowMaximum.java
// java SlidingWindowMaximum
// ```

// **Output:**
// ```
// [3, 3, 5, 5, 6, 7]