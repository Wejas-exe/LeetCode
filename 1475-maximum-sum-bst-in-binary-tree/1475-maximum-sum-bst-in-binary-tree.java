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
    public class Info {
        boolean isBst;
        int sum;
        int min;
        int max;

        public Info(boolean isBst, int sum, int min, int max) {
            this.isBst = isBst;
            this.sum = sum;
            this.min = min;
            this.max = max;
        }
    }
    private int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        max(root);
        return maxSum;
    }

    public Info max(TreeNode root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = max(root.left);
        Info rightInfo = max(root.right);

        if (leftInfo.max >= root.val || rightInfo.min <= root.val) {
            maxSum = Math.max(maxSum, Math.max(leftInfo.sum, rightInfo.sum));
            return new Info(false, 0, 0, 0);
        }
        if (leftInfo.isBst && rightInfo.isBst) {
            int sum = leftInfo.sum + rightInfo.sum + root.val;
            int min = Math.min(root.val, Math.min(leftInfo.min, rightInfo.min));
            int max = Math.max(root.val, Math.max(leftInfo.max, rightInfo.max));
            maxSum = Math.max(maxSum, sum);

            return new Info(true, sum, min, max);
        }

        maxSum = Math.max(maxSum, Math.max(leftInfo.sum, rightInfo.sum));
        return new Info(false, 0, 0, 0);
    }
}
