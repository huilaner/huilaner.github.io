/**
 * difficulty: easy
 * url: https://leetcode.com/problems/path-sum/
 * tag: Tree DFS
 * time complexity: O(log n), space: ??
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return ifFoundPath(0, sum, root);
    }
    
    public boolean ifFoundPath(int curr, int target, TreeNode node){
        if(node == null && curr != target) return false;
        curr += node.val;
        if(node.left != null && ifFoundPath(curr, target, node.left)) return true;
        if(node.right != null && ifFoundPath(curr, target, node.right)) return true;
        if(curr == target && node.left == null && node.right == null) return true;
        return false;
    }

    //another solution of recursion
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.val == sum && (root.left == null && root.right == null))
            return true;
     
        return hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);
    }

    //using queue and BFS
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
 
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> values = new LinkedList<Integer>();
 
        nodes.add(root);
        values.add(root.val);
 
        while(!nodes.isEmpty()){
            TreeNode curr = nodes.poll();
            int sumValue = values.poll();
 
            if(curr.left == null && curr.right == null && sumValue==sum){
                return true;
            }
 
            if(curr.left != null){
                nodes.add(curr.left);
                values.add(sumValue+curr.left.val);
            }
 
            if(curr.right != null){
                nodes.add(curr.right);
                values.add(sumValue+curr.right.val);
            }
        }
 
        return false;
    }

}
