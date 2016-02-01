/**
 * difficulty: medium
 * url: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
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
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || preorder.length != inorder.length) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1, map);
    }
    
    private TreeNode build(int[] preorder, int[] inorder, int p1, int p2, int i1, int i2, HashMap<Integer, Integer> map){
        if(p1 > p2 || i1 > i2) return null;
        int rootVal = preorder[p1];
        int rootIdx = map.get(rootVal);
        int range = rootIdx - i1;
        TreeNode root = new TreeNode(rootVal);
        TreeNode left = build(preorder, inorder, p1+1, p1+range, i1, rootIdx-1, map);
        TreeNode right = build(preorder, inorder, p1+range+1, p2, rootIdx+1, i2, map);
        root.left = left;
        root.right = right;
        return root;
        
    }
}