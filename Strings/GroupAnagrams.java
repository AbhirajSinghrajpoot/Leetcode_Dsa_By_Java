import java.util.*;

public class GroupAnagrams {
    
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // String ko character array mein convert karke sort karo
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            
            // Agar sorted string map mein nahi hai, toh nayi list daalo
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            // Original string ko uski sahi list mein add kar do
            map.get(sortedStr).add(s);
        }
        
        return new ArrayList<>(map.values());
    }

    // --- Driver Code for VS Code ---
    public static void main(String[] args) {
        String[] test1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] test2 = {""};
        String[] test3 = {"a"};
        
        System.out.println("Test 1: " + groupAnagrams(test1));
        // Expected Output: [[eat, tea, ate], [bat], [tan, nat]] (Groups ka order vary kar sakta hai)
        
        System.out.println("Test 2: " + groupAnagrams(test2));
        // Expected Output: [[]]
        
        System.out.println("Test 3: " + groupAnagrams(test3));
        // Expected Output: [[a]]
    }
}
