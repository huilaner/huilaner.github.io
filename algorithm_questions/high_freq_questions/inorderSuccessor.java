/**
  * https://www.lintcode.com/en/problem/inorder-successor-in-binary-search-tree/
  *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * 1) If right subtree of node is not NULL, then succ lies in right subtree. Do following.
 * Go to right subtree and return the node with minimum key value in right subtree.
 * 2) If right sbtree of node is NULL, then succ is one of the ancestors. Do following.
 * Travel up using the parent pointer until you see a node which is left child of it’s parent. The parent of such a node is the succ.
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        
        while(root != null && root != p){
            if(p.val < root.val){
                successor = root;
                root = root.left;
            }else{
                root = root.right;
            }
        }
        
        if(root == null) return null;
        
        if(root.right == null) return successor;
        
        root = root.right;
        while(root.left != null){
            root = root.left;
        }
        
        return root;

    }
}
