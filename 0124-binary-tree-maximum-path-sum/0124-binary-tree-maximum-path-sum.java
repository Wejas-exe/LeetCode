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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        path(root);
        return maxSum;
    }
    public int path(TreeNode root){
        if(root == null ) return 0;

        int leftSum = Math.max(0,path(root.left));
        int rightSum = Math.max(0,path(root.right));
        int nodeSum = leftSum +rightSum + root.val;

        maxSum = Math.max(nodeSum, maxSum);
        return Math.max(leftSum+root.val,rightSum+root.val);
    }
}