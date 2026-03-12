class LongestPalindromicSubstringSolution {

    public String longestPalindrome(String s) {

        String res = "";

        for (int i = 0; i < s.length(); i++) {

            String odd = expand(s, i, i);
            String even = expand(s, i, i + 1);

            if (odd.length() > res.length()) {
                res = odd;
            }

            if (even.length() > res.length()) {
                res = even;
            }
        }

        return res;
    }

    public String expand(String s, int left, int right) {

        while (left >= 0 && right < s.length() &&
                s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}

class LongestPalindromicSubstring {
    public static void main(String[] args) {
        LongestPalindromicSubstringSolution sol = new LongestPalindromicSubstringSolution();
        String s = "babad";
        System.out.println(sol.longestPalindrome(s));
    }
}
