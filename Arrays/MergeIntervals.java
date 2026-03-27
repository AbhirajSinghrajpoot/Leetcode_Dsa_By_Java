import java.util.*;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        for (int[] curr : intervals) {

            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < curr[0]) {
                merged.add(new int[]{curr[0], curr[1]});
            } else {
                merged.get(merged.size() - 1)[1] =
                        Math.max(merged.get(merged.size() - 1)[1], curr[1]);
            }
        }

<<<<<<< HEAD
        return merged.toArray(int[][]::new);
=======
        return merged.toArray(new int[merged.size()][]);
>>>>>>> 35b015ff1fb00f0b57d8cbb862cdc14c4de88809
    }

    public static void main(String[] args) {

        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        int[][] result = merge(intervals);

        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(Arrays.toString(result[i]));
            if (i != result.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
