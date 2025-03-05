/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int dfs(TreeNode node) {
        if (node == null)
            return 0;
        
        return 1 + Math.max(dfs(node.left), dfs(node.right));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        
        return (
            Math.abs(dfs(root.left) - dfs(root.right)) < 2 &&
            isBalanced(root.left) &&
            isBalanced(root.right)
        );
    }
}