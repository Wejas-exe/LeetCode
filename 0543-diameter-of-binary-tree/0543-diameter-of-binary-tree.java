class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        return diameterAndHeight(root).diam;
    }
    
    private Info diameterAndHeight(TreeNode root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diameterAndHeight(root.left);
        Info rightInfo = diameterAndHeight(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht);
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(diam, ht);
    }

    static class Info {
        int diam;
        int ht;

        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }
}
