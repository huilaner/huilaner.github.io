/**
 * difficulty: medium
 * url: https://leetcode.com/problems/count-complete-tree-nodes/
 * tag: tree, binary search
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
    public int countNodes(TreeNode root) {
        int leftHeight = subNode(root, 0); //0 is left, 1 is right
        int rightHeight = subNode(root, 1);
        if(leftHeight == rightHeight) return (1<<leftHeight)-1;//full tree
        else return 1+countNodes(root.left)+countNodes(root.right);
    }
    
    private int subNode(TreeNode n, int LoR){
        int dep = 0;
        while(n != null){
            if(LoR == 0) n = n.left;
            else n = n.right;
            dep++;
        }
        return dep;
    }
    
}





// time out
public class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        //get height(original height-1)
        TreeNode p = root;
        if(root.left == null) return 1;
        int height = 0;
        while(p.left != null){
            p = p.left;
            height++;
        }//p is the leftmost node in the leaves
        int sum = 0;
        for(int i = 0; i < height; i++){
            sum += (int)Math.pow(2, i);
        }
        // System.out.println("sum:"+sum+" p:"+p.val);
        //count the last layer of leaves
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        boolean leafBegin = false;
        while(!q.isEmpty()){
            TreeNode n = q.poll();
            if(n != root && n == p) leafBegin = true;
            if(n.left != null) q.offer(n.left);
            if(n.right != null) q.offer(n.right);
            if(leafBegin) sum++;
        }
        return sum;
    }
}