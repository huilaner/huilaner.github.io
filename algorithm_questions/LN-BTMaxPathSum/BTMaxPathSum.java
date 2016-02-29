/**
 * difficulty: medium
 * url: http://www.lintcode.com/en/problem/binary-tree-maximum-path-sum/#
 * tag: divide and conquer, binary tree
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
     * @param root: The root of binary tree.
     * @return: An integer.
     */
     
    private class Path{
        public int singlePath;
        public int maxPath;
        public Path(int s, int m){
            this.singlePath = s;
            this.maxPath = m;
        }
    }
    
    public int maxPathSum(TreeNode root) {
        Path result = findPath(root);
        return result.maxPath;
    }
    
    public Path findPath(TreeNode root){
        Path p = new Path(0, Integer.MIN_VALUE);
        if(root == null) return p;
        
        Path left = findPath(root.left);
        Path right = findPath(root.right);

        int single = Math.max(left.singlePath, right.singlePath);
        single = Math.max(root.val+single, 0);
        int max = Math.max(left.maxPath, right.maxPath);
        max = Math.max(max, right.singlePath+left.singlePath+root.val);
        
        return new Path(single, max);
    }
}
