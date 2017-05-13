/**
  * https://www.lintcode.com/en/problem/convert-bst-to-greater-tree
  *
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @return the new root
     */
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        return dfs(root);
    }
    
    //post-order traversal
    private TreeNode dfs(TreeNode root){
        if(root == null) return null;
        dfs(root.right);
        sum += root.val;
        root.val = sum;
        dfs(root.left);
        return root;
    }
}
