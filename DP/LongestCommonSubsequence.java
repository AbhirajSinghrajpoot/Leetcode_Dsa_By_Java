public class LongestCommonSubsequence {
    
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        
        // 2D DP Table, shuru mein sab 0 hoga
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // Agar characters match karein
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // Diagonal + 1
                } else {
                    // Agar mismatch ho
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // Max of Upar ya Peeche
                }
            }
        }
        
        return dp[m][n];
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        
        String text3 = "abc";
        String text4 = "def";
        
        System.out.println("--- 3. Longest Common Subsequence ---");
        System.out.println("LCS of 'abcde' & 'ace': " + longestCommonSubsequence(text1, text2)); // Output: 3
        System.out.println("LCS of 'abc' & 'def': " + longestCommonSubsequence(text3, text4)); // Output: 0
    }
}