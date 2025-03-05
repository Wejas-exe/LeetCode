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
    private int di = 0;
    public int getHeight(TreeNode root){
        if(root == null) return 0;

        int lh = getHeight(root.left);
        int rh = getHeight(root.right);

        int currDiam = lh +rh;

        di = Math.max(di,currDiam);
        return Math.max(lh , rh)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return di;
    }
}