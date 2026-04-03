public class ClimbingStairs {
    
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        
        int prev2 = 1; 
        int prev1 = 2; 
        
        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2; 
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1; 
    }

    public static void main(String[] args) {
        int n1 = 5;
        int n2 = 10;
        
        System.out.println("--- 1. Climbing Stairs ---");
        System.out.println("Ways to climb " + n1 + " stairs: " + climbStairs(n1)); // Output: 8
        System.out.println("Ways to climb " + n2 + " stairs: " + climbStairs(n2)); // Output: 89
    }
}