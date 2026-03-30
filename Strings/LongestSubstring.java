import java.util.HashSet;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String test1 = "abcabcbb";
        String test2 = "pwwkew";

        System.out.println("Test 1 (abcabcbb): " + lengthOfLongestSubstring(test1)); // Expected: 3
        System.out.println("Test 2 (pwwkew): " + lengthOfLongestSubstring(test2));   // Expected: 3
    }
}
