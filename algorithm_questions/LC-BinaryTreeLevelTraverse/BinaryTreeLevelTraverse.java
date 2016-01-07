/**
 * difficulty: easy
 * url: https://leetcode.com/problems/binary-tree-level-order-traversal/
 * tag: Tree, BFS
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if(root == null) return result;
        
        List<TreeNode> currList = new LinkedList<TreeNode>();
        List<TreeNode> nextList = new LinkedList<TreeNode>();
        currList.add(root);
        
        List<Integer> intList = new LinkedList<Integer>();
        
        while(!currList.isEmpty()){
            TreeNode n = currList.remove(0);
            intList.add(n.val);
            
            if(n.left != null) nextList.add(n.left);
            if(n.right != null) nextList.add(n.right);
            
            if(currList.isEmpty()){
                currList = nextList;
                nextList = new LinkedList<TreeNode>();
                result.add(intList);
                intList = new LinkedList<Integer>();
                
            }
        }
        
        return result;
    }
}
