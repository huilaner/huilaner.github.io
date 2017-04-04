/**
 * difficulty: mediium
 * url: https://www.lintcode.com/en/problem/binary-tree-maximum-path-sum/
 * tag: binarytree, DP, recursion, divide&conquer
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
    public int maxPathSum(TreeNode root) {
        int[] rst = helper(root);
        return rst[1];
    }
    
    private int[] helper(TreeNode root){
        int[] ary = new int[2]; //singlePath, maxPath
        if(root == null) {
            ary[0] = Integer.MIN_VALUE;
            ary[1] = Integer.MIN_VALUE;
            return ary;
        }
        
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        
        int singlePath = Math.max(0, Math.max(left[0], right[0])) + root.val;
        ary[0] = singlePath;
        
        int maxPath = Math.max(left[1], right[1]);
        maxPath = Math.max(maxPath, Math.max(0, left[0]) + Math.max(0, right[0]) + root.val);
        ary[1] = maxPath;
        
        return ary;
    }
}
