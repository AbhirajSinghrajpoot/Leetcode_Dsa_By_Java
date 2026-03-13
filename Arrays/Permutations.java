import java.util.*;

public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }

    static void backtrack(int[] nums, List<Integer> temp, List<List<Integer>> result) {

        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (temp.contains(nums[i])) continue;

            temp.add(nums[i]);
            backtrack(nums, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        System.out.println(permute(nums));
    }
}