public class MaxSumSubarray {
    public static int findMaxSumSubArray(int k, int[] arr) {
        int maxSum = 0, windowSum = 0, windowStart = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // Add next element

            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart]; // Remove first element
                windowStart++; // Slide window
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Input Array: [2, 1, 5, 1, 3, 2], K: " + k);
        System.out.println("Maximum Sum: " + findMaxSumSubArray(k, arr)); // Expected: 9
    }
}