/**
 * difficulty: medium
 * url: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * tag: Tree, BinarySearch
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
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        //use in-order traversal
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        int result = 0;
        while(!stack.isEmpty() || p != null){
            if(p != null){
                stack.push(p);
                p = p.left;
            }else{
                TreeNode n = stack.pop();
                k--;
                if(k == 0 ) return n.val;
                p = n.right;
            }
        }
        return result;
    }
    

}
