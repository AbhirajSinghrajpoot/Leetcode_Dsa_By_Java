// LeetCode 242 - Valid Anagram
// Problem: Given two strings s and t, return true if t is an anagram of s.
// Approach: Count frequency of each character using an int array of size 26.
//           Increment for s, decrement for t — if all zeros at end → anagram.
// Time: O(n) | Space: O(1)

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println(isAnagram("anagram", "nagaram")); // true
        System.out.println(isAnagram("rat", "car"));         // false
    }
}
