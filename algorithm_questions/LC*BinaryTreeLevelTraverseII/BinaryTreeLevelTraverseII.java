/**
 * difficulty: easy
 * url: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * tag: tree, BFS
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if(root == null) return list;
        
        LinkedList<TreeNode> currList = new LinkedList<>();
        LinkedList<TreeNode> nextList = new LinkedList<>();
        Stack<List<Integer>> stack = new Stack<List<Integer>>();
        currList.add(root);
        List<Integer> intList = new LinkedList<Integer>();
        
        while(!currList.isEmpty()){
            TreeNode n = currList.remove();
            intList.add(n.val);
            if(n.left != null) nextList.add(n.left);
            if(n.right != null) nextList.add(n.right);
            if(currList.isEmpty()){
                List<Integer> tmp = new LinkedList<Integer>();
                stack.add(intList);
                intList = new LinkedList<Integer>();
                currList = nextList;
                nextList = new LinkedList<>();
            }

        }
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
}
