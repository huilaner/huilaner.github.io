/**
 * difficulty: easy
 * url: https://leetcode.com/problems/symmetric-tree/
 * tag: Tree, DFS?
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSym(root.left, root.right);
    }
    
    public boolean isSym(TreeNode l, TreeNode r){
        if((l == null && r != null) || (l != null && r == null)) return false;
        if(l == null && r == null) return true;
        if(l.val != r.val) return false;
        if(!isSym(l.left, r.right) || !isSym(l.right, r.left)) return false;
        return true;
    }
}
