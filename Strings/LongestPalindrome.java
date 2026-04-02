public class LongestPalindrome {

    public static String longestPalindrome(String s) {

        String res = "";

        for (int i = 0; i < s.length(); i++) {

            String odd = expand(s, i, i);
            String even = expand(s, i, i + 1);

            if (odd.length() > res.length()) res = odd;
            if (even.length() > res.length()) res = even;
        }

        return res;
    }

    public static String expand(String s, int left, int right) {

        while (left >= 0 && right < s.length() &&
                s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {

        String s = "babad";

        System.out.println(longestPalindrome(s));
    }
}
// public class LongestPalindrome {

//     // Main logic function
//     public static String longestPalindrome(String s) {
//         if (s == null || s.length() < 1) return "";
        
//         int start = 0, end = 0;
        
//         for (int i = 0; i < s.length(); i++) {
//             // Odd length palindrome check
//             int len1 = expandAroundCenter(s, i, i);
//             // Even length palindrome check
//             int len2 = expandAroundCenter(s, i, i + 1);
            
//             int len = Math.max(len1, len2);
            
//             // Agar naya lamba palindrome mila toh boundaries update karo
//             if (len > end - start) {
//                 start = i - (len - 1) / 2;
//                 end = i + len / 2;
//             }
//         }
//         // Substring extract karke return karo
//         return s.substring(start, end + 1);
//     }

//     // Helper function to expand around center
//     private static int expandAroundCenter(String s, int left, int right) {
//         int L = left, R = right;
//         while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
//             L--;
//             R++;
//         }
//         // Return the length of the palindrome found
//         return R - L - 1;
//     }

//     // Runnable main method with test cases
//     public static void main(String[] args) {
//         String test1 = "babad";
//         String test2 = "cbbd";
        
//         System.out.println("--- Longest Palindromic Substring ---");
//         System.out.println("Input: " + test1 + " | Output: " + longestPalindrome(test1));
//         System.out.println("Input: " + test2 + " | Output: " + longestPalindrome(test2));
//     }
// // }