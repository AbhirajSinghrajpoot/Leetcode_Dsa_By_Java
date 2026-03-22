public class FindRotation {

    public boolean findRotation(int[][] mat, int[][] target) {

        for (int k = 0; k < 4; k++) {

            if (equals(mat, target)) return true;

            mat = rotate(mat);
        }

        return false;
    }

    int[][] rotate(int[][] mat) {
        int n = mat.length;
        int[][] res = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[j][n - 1 - i] = mat[i][j];
            }
        }
        return res;
    }

    boolean equals(int[][] mat, int[][] target) {
        int n = mat.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[][] mat = {
            {0, 1},
            {1, 0}
        };

        int[][] target = {
            {1, 0},
            {0, 1}
        };

        FindRotation solver = new FindRotation();
        boolean ans = solver.findRotation(mat, target);

        System.out.println(ans);
    }
}
