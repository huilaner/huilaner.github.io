/**
 * difficulty: medium
 * url: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * tag: tree, BFS, stack
 * time: O(n), space: O(maxLevelNodes)
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//iterative solution
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if(root == null) return list;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        boolean order = true;//->

        List<Integer> l = new LinkedList<Integer>();
        l.add(root.val);
        while(!q.isEmpty()){
            l = new LinkedList<Integer>(); 
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                TreeNode curr = q.remove();
                if(order) l.add(curr.val);
                else l.add(0, curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            order = !order;
            list.add(l);
            l = new LinkedList<Integer>();
            
        }
        return list;
    }
}


//recursive
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if(root == null) return list;
        travel(root, list, 0);
        return list;
    }
    
    private void travel(TreeNode n, List<List<Integer>> list, int level){
        if(n == null) return;
        if(list.size() <= level){
           List<Integer> newList = new LinkedList<Integer>();
           list.add(newList);
        }
        List<Integer> currList = list.get(level);
        if(level%2 == 0) currList.add(n.val); //->
        else currList.add(0, n.val);//<-
        
        if(n.left != null) travel(n.left, list, level+1);
        if(n.right != null) travel(n.right, list, level+1);
    }
}