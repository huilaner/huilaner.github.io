/**
 * difficulty: easy
 * url: https://leetcode.com/problems/binary-tree-paths/
 * tag: Tree, DFS
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new LinkedList<String>();
        if(root == null) return list;
        
        //note: since the reference of list will pass in by value, list can be altered if carefully
        getAllPaths(root, ""+root.val, list);
        
        return list;
        
    }
    
    public void getAllPaths(TreeNode n, String prevPath, List<String> list){
        if(n.left == null && n.right == null) {
            list.add(prevPath); 
            return;
        }

        if(n.left != null) {
            getAllPaths(n.left, prevPath+"->"+n.left.val, list);
        }
        if(n.right != null) {
            getAllPaths(n.right, prevPath+"->"+n.right.val, list);
        }

    }
}
