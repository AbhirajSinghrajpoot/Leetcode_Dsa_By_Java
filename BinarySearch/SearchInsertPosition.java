package BinarySearch;

import java.util.*;

public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            // Input
            System.out.print("Enter array size: ");
            int n = sc.nextInt();

            int[] nums = new int[n];
            System.out.println("Enter sorted array:");
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            System.out.print("Enter target: ");
            int target = sc.nextInt();

            // Output
            int result = searchInsert(nums, target);
            System.out.println("Insert Position: " + result);
        }
    }
}
