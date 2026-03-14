// LeetCode 1119 - Remove Vowels from a String  (variant: Count Vowels)
// Problem: Count the number of vowels (a, e, i, o, u) in a given string.
// Approach: Iterate each character and check if it is a vowel using a set/string.
// Time: O(n) | Space: O(1)

public class CountVowels {

    public static int countVowels(String s) {

        String vowels = "aeiouAEIOU";
        int count = 0;

        for (char c : s.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        System.out.println(countVowels("Hello World")); // 3  (e, o, o)
        System.out.println(countVowels("leetcode"));    // 4  (e, e, o, e)
    }
}
