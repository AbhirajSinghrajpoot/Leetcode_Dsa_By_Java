public class FindRotation {

    // Check karte hain ki mat ko 0, 90, 180, 270 degree ghumake target ban sakta hai ya nahi.
    public boolean findRotation(int[][] mat, int[][] target) {

        // Maximum 4 unique rotations hoti hain square matrix ki.
        for (int k = 0; k < 4; k++) {

            // Agar current orientation already target ke equal hai to answer true.
            if (equals(mat, target)) return true;

            // Warna matrix ko 90 degree clockwise rotate karke next check ke liye ready karo.
            mat = rotate(mat);
        }

        // 4 attempts ke baad bhi match na mile to false.
        return false;
    }

    // Nayi matrix bana kar 90 degree clockwise rotation perform karta hai.
    int[][] rotate(int[][] mat) {
        int n = mat.length;
        int[][] res = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Old position (i, j) ki value new position (j, n - 1 - i) par jayegi.
                res[j][n - 1 - i] = mat[i][j];
            }
        }
        return res;
    }

    // Dono matrices ke har cell ko compare karta hai.
    boolean equals(int[][] mat, int[][] target) {
        int n = mat.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Ek bhi mismatch milte hi matrices equal nahi hain.
                if (mat[i][j] != target[i][j]) return false;
            }
        }
        // Sab values same hain to matrices equal hain.
        return true;
    }

    public static void main(String[] args) {

        // Example input matrix.
        int[][] mat = {
            {0, 1},
            {1, 0}
        };

        // Target matrix jisse match karna hai (rotation ke through).
        int[][] target = {
            {1, 0},
            {0, 1}
        };

        FindRotation solver = new FindRotation();
        boolean ans = solver.findRotation(mat, target);

        // true ka matlab rotation se target mil gaya.
        System.out.println(ans);
    }
}
