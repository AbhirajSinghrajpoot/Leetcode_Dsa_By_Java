public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }

        int[] targetCount = new int[128];
        for (char c : t.toCharArray()) {
            targetCount[c]++;
        }

        int left = 0, right = 0, minLen = Integer.MAX_VALUE, startIndex = 0;
        int requiredChars = t.length();

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (targetCount[rightChar] > 0) {
                requiredChars--;
            }
            targetCount[rightChar]--;
            right++;

            while (requiredChars == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);
                targetCount[leftChar]++;
                if (targetCount[leftChar] > 0) {
                    requiredChars++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Input String: " + s + " | Target: " + t);
        System.out.println("Minimum Window: " + minWindow(s, t)); // Expected: "BANC"
    }
}
