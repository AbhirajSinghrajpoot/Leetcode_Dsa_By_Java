public class ValidPalindrome {
    
    // Core logic jo humne discuss kiya tha
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false; 
            }
            
            left++;
            right--;
        }
        
        return true; 
    }
    public static void main(String[] args) {
        // Test cases directly from LeetCode
        String test1 = "A man, a plan, a canal: Panama";
        String test2 = "race a car";
        String test3 = " ";
        
        System.out.println("Test 1 ('A man...'): " + isPalindrome(test1)); // Expected: true
        System.out.println("Test 2 ('race a car'): " + isPalindrome(test2)); // Expected: false
        System.out.println("Test 3 (' '): " + isPalindrome(test3));        // Expected: true
    }
}
