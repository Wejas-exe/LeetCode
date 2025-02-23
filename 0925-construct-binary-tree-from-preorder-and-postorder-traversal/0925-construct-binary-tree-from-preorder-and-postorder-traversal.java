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
    private int n ;
    private int []pre ;
    private int []post ;
    private TreeNode buildTree(int preS , int postS , int postE , int[] preOrder, int[] postOrder){
        if (postS > postE) return null ;
        TreeNode root = new TreeNode(preOrder[preS]);
        if (postS == postE) return root ;// LeafNode
        
        int leftRootVal = preOrder[preS+1] ;
        int lrPostIdx = post[leftRootVal] ;

        root.left = buildTree(preS+1,postS, lrPostIdx , preOrder, postOrder);
        root.right = buildTree(pre[postOrder[postE-1]],lrPostIdx+1,postE-1, preOrder, postOrder);
        return root ;
    }
    public TreeNode constructFromPrePost(int[] preOrder, int[] postOrder) {
        n = preOrder.length ;

        pre = new int[n+1];
        post = new int[n+1];
        for (int i = 0; i <n ; i++){
            pre[preOrder[i]] =  i;
            post[postOrder[i]] =  i;
        }
        return buildTree(0  , 0, n-1 , preOrder, postOrder );
    }
}