class Solution {
  public TreeNode recoverFromPreorder(String traversal) {
    return helper(new StringBuilder(traversal), -1);
  }

  private TreeNode helper(StringBuilder traversal, int depth) {
    int count = 0;
    while (count < traversal.length() 
            && count < depth + 1 
            && traversal.charAt(count) == '-') {
      count++;
    }
    if (count >= traversal.length() || count < depth + 1 || traversal.charAt(count) == '-') {
      return null;
    }

    int num = 0;
    while (count < traversal.length() && traversal.charAt(count) != '-') {
      num *= 10;
      num += traversal.charAt(count) - '0';
      count++;
    }

    TreeNode curr = new TreeNode(num);
    traversal.delete(0, count);
    curr.left = helper(traversal, depth + 1);
    curr.right = helper(traversal, depth + 1);

    return curr;
  }
}