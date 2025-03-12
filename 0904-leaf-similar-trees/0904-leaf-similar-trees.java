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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        boolean a = getLeaf(root1,list1);
        boolean b = getLeaf(root2,list2);

        if(list1.equals(list2)) return true;
        return false;

    }
    public boolean getLeaf(TreeNode root , List<Integer> list){
        if(root == null){
            return false;
        }
        boolean left = getLeaf(root.left,list);
        boolean right = getLeaf(root.right,list);

        if(!left && !right){
            list.add(root.val);
        }
        return true;
    }
}