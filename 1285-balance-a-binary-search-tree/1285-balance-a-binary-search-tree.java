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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        path(root , list);
        return bst(list,0,list.size()-1);
    }
    public TreeNode bst(ArrayList<Integer> list , int left , int right){
        if(left > right) return null;
        int mid = left +(right-left)/2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = bst(list , left ,mid-1);
        node.right = bst(list, mid+1 , right);
        return node ;
    }
    public void path(TreeNode root , ArrayList<Integer> list){
        if(root == null) return ;
        path(root.left , list);
        list.add(root.val);
        path(root.right,list);
    }
}