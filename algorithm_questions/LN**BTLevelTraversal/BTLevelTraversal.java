/**
 * difficulty: medium
 * url: http://www.lintcode.com/en/problem/binary-tree-level-order-traversal/
 * tag: binary tree, BFS
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
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        int sizeCurrLevel = 1;
        int sizeNextLevel = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            list.add(curr.val);
            if(curr.left != null) {
                q.offer(curr.left);
                sizeNextLevel++;
            }
            if(curr.right != null) {
                q.offer(curr.right);
                sizeNextLevel++;
            }
            sizeCurrLevel --;
            if(sizeCurrLevel == 0){
                result.add(list);
                list = new ArrayList<Integer>();
                sizeCurrLevel = sizeNextLevel;
                sizeNextLevel = 0;
            }
            
        }
        
        return result;
    }
}