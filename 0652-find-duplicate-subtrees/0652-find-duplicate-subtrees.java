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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        serialize(root , map , list);
        return list;
    }
    public String serialize(TreeNode root ,HashMap<String,Integer> map, List<TreeNode> list){
        if(root == null){
            return "#";
        }
        String serial = root.val + "," +serialize(root.left,map,list) +"," +serialize(root.right,map,list);
        map.put(serial,map.getOrDefault(serial,0)+1);
        if(map.get(serial) == 2){
            list.add(root);
        }
        return serial; 
    }
}