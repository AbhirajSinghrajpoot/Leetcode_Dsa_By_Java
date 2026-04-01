public class PalindromicSubstrings {
    
    // Instance variable to keep track of count
    int count = 0; 

    // Main logic function
    public int countSubstrings(String s) {
        count = 0; // Reset count for multiple test case runs
        if (s == null || s.length() == 0) return 0;

        for (int i = 0; i < s.length(); i++) {
            // Odd length palindromes (Center = 1 character)
            expandAroundCenter(s, i, i);
            
            // Even length palindromes (Center = between 2 characters)
            expandAroundCenter(s, i, i + 1);
        }
        
        return count;
    }

    // Helper function to expand around center and count
    private void expandAroundCenter(String s, int left, int right) {
        // Jab tak pointers valid hain aur characters match kar rahe hain
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;   // Palindrome mil gaya! Count badhao.
            left--;    // Expand outwards to the left
            right++;   // Expand outwards to the right
        }
    }

    // Runnable main method with test cases
    public static void main(String[] args) {
        // Class ka object banana padega kyunki countSubstrings non-static hai
        PalindromicSubstrings solution = new PalindromicSubstrings();
        
        String test1 = "abc";
        String test2 = "aaa";
        
        System.out.println("--- Count Palindromic Substrings ---");
        System.out.println("Input: " + test1 + " | Total Palindromes: " + solution.countSubstrings(test1));
        System.out.println("Input: " + test2 + " | Total Palindromes: " + solution.countSubstrings(test2));
    }
}