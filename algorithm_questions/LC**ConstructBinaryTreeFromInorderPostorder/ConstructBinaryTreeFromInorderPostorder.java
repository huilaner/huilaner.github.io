/**
 * difficulty: medium
 * url: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * tag: tree, array, DFS
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 //take the last element in postorder array as the root, find the position of the root in the inorder array; then locate the range for left sub-tree and right sub-tree and do recursion. Use a HashMap to record the index of root in the inorder array.
public class Solution {
    HashMap<Integer, Integer> inMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length != postorder.length || inorder.length == 0) return null;
        int len = inorder.length;
        TreeNode root = new TreeNode(postorder[len-1]);
        for(int i = 0; i < len; i++){
            inMap.put(inorder[i], i);
        }
        int rootIdx = inMap.get(postorder[len-1]);
        root = build(inorder, postorder, 0, len-1, 0, len-1);
        return root;
    }
    private TreeNode build(int[] inorder, int[] postorder, int i1, int i2, int p1, int p2){
        if(i1 > i2 || p1 > p2) return null;
        int rootVal = postorder[p2];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = inMap.get(rootVal);
        int range = rootIdx -1 - i1; //**key point
        TreeNode left = build(inorder, postorder, i1, rootIdx-1, p1, p1+range);
        TreeNode right = build(inorder, postorder, rootIdx+1, i2, p1+range+1, p2-1);
        root.left = left;
        root.right = right;
        return root;
        
    }
}