/**
 * difficulty: medium
 * url:
 * tag: tree, DP
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
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return (List<TreeNode>) new LinkedList<TreeNode>();
        return getTrees(1,n);
    }
    
    // ith node as root, left: 1 ~ i-1, right: i+1 ~ n
    private List<TreeNode> getTrees(int start, int end){
        List<TreeNode> list = new LinkedList<TreeNode>();
        if(start > end) {
            list.add(null);
            return list;
        }
        if(start == end){
            TreeNode node = new TreeNode(start);
            list.add(node);
            return list;
        }
        List<TreeNode> left, right;
        for(int i = start; i <= end; i++){
            left = getTrees(start, i-1);
            right = getTrees(i+1, end);
            
            for(TreeNode l : left){
                for(TreeNode r: right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
            
        }
        
        return list;

    }
}