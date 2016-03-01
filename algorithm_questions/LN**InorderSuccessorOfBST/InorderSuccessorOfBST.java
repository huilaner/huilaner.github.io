/**
 * difficulty: medium
 * url: http://www.lintcode.com/en/problem/inorder-successor-in-binary-search-tree/
 * tag: BST, binary tree
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
    //use iterative traversal method for all BT
    // O(n)
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        boolean meetTarget = false;
        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(meetTarget) return curr;
            if(curr.val == p.val){
                meetTarget = true;
            }
            curr = curr.right;
        }
        return null;
    }

    //just for BST
    //O(logN)
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        if(root == null) return null;
        TreeNode successor = null;
        TreeNode curr = root;
        //find p
        while(curr != null && p.val != curr.val){
            if(p.val < curr.val){
                successor = curr;
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }
        
        //not found p
        if(curr == null){
            return null;
        }
        
        if(curr.right == null){
            return successor;
        }else{ // go to the leftmost in its right
            curr = curr.right;
            while(curr.left != null){
                curr = curr.left;
            }
            return curr;
        }

    }
}