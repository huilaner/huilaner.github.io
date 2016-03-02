/**
 * difficulty: medium
 * ulr: http://www.lintcode.com/en/problem/lowest-common-ancestor/
 * tag: BT
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
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        return findNodes(root, A, B);
    }
    
    public TreeNode findNodes(TreeNode root, TreeNode A, TreeNode B){
        if(root == null || root == A || root == B) return root;
        
        TreeNode left = findNodes(root.left, A, B);
        TreeNode right = findNodes(root.right, A, B);
        
        if(left != null && right != null) return root;
        
        if(left != null) return left;
        if(right != null) return right;
        return null;
    }
}