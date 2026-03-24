import java.util.*;

public class ConstructProductMatrix {

    public static int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int size = n * m;
        int MOD = 12345;

        int[] prefix = new int[size];
        int[] suffix = new int[size];

        // Prefix
        prefix[0] = 1;
        for (int i = 1; i < size; i++) {
            int r = (i - 1) / m;
            int c = (i - 1) % m;
            prefix[i] = (prefix[i - 1] * grid[r][c]) % MOD;
        }

        // Suffix
        suffix[size - 1] = 1;
        for (int i = size - 2; i >= 0; i--) {
            int r = (i + 1) / m;
            int c = (i + 1) % m;
            suffix[i] = (suffix[i + 1] * grid[r][c]) % MOD;
        }

        // Result
        int[][] ans = new int[n][m];
        for (int i = 0; i < size; i++) {
            int r = i / m;
            int c = i % m;
            ans[r][c] = (prefix[i] * suffix[i]) % MOD;
        }

        return ans;
    }

    // Print function
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // Input
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            // Solve
            int[][] result = constructProductMatrix(grid);

            // Output
            printMatrix(result);
        }
    }
}
