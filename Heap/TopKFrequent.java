import java.util.*;

public class TopKFrequent {
    
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int[] res = new int[k];
        int counter = 0;
        
        for (int i = bucket.length - 1; i >= 0 && counter < k; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    res[counter++] = num;
                    if (counter == k) return res; 
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        
        int[] result = topKFrequent(nums, k);
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Top " + k + " Frequent Elements: " + Arrays.toString(result));
    }
}