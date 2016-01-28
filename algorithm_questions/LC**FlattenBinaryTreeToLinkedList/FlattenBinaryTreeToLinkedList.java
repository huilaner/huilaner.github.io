/**
 * difficulty: medium
 * url: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * tag: DFS
 * time: O(logN), space: O(logN)
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private TreeNode prev;
    public void flatten(TreeNode root) {
        flatten(root, null);

    }

    private TreeNode flatten(TreeNode root, TreeNode prev){
        if (root == null) return prev;
        prev = flatten(root.right, prev);
        prev = flatten(root.left, prev);
        root.right = prev;
        root.left = null;
        prev = root;
        return prev;
    }




}
