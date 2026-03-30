public class CharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0, maxLength = 0, maxFreq = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            count[rightChar - 'A']++;
            maxFreq = Math.max(maxFreq, count[rightChar - 'A']);

            if ((right - left + 1) - maxFreq > k) {
                char leftChar = s.charAt(left);
                count[leftChar - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s1 = "ABAB";
        int k1 = 2;
        System.out.println("Test 1 (" + s1 + ", k=" + k1 + "): " + characterReplacement(s1, k1)); // Expected: 4

        String s2 = "AABABBA";
        int k2 = 1;
        System.out.println("Test 2 (" + s2 + ", k=" + k2 + "): " + characterReplacement(s2, k2)); // Expected: 4
    }
}
