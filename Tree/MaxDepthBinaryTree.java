// LeetCode wali TreeNode class jo VS Code ke liye zaroori hai
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {}
    
    TreeNode(int val) { 
        this.val = val; 
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MaxDepthBinaryTree {
    
    // Tumhara original logic
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        // Test Case: root = [3,9,20,null,null,15,7]
        // Manually tree bana rahe hain VS Code ke liye
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("--- 104. Maximum Depth of Binary Tree ---");
        System.out.println("Tree ki Maximum Depth hai: " + maxDepth(root)); // Output 3 aana chahiye
    }
}