/**
 * difficulty: medium
 * url: https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * tag: tree, DFS
 * time: log(N), space: log(N)??
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
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }
    
    public int sum(TreeNode n, int parentVal){
        if(n == null) return 0;
        if(n.left == null && n.right == null) return parentVal * 10 + n.val;
        else return sum(n.left, parentVal*10+n.val)+ sum(n.right, parentVal*10+n.val);
    }
}
