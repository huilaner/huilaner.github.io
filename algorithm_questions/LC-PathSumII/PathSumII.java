/**
 * difficulty: medium
 * url: https://leetcode.com/problems/path-sum-ii/
 * tag: tree, DFS
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if(root ==  null) return list;
        List<Integer> currList = new LinkedList<Integer>();
        getPath(root, sum, currList, list);
        return list;
    }

    private void getPath(TreeNode root, int currSum, List<Integer> currList, List<List<Integer>> list){
        currList.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == root.val) list.add(currList);
        }
        else {
            if(root.left != null){
                List<Integer> newList = new LinkedList<Integer>(currList);
                getPath(root.left, currSum-root.val, newList, list);
            }
            if(root.right != null){
                List<Integer> newList = new LinkedList<Integer>(currList);
                getPath(root.right, currSum-root.val, newList, list);
            }
        }

        return;
        
    }
}
