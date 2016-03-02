/**
 * difficulty: medium
 * url: http://www.lintcode.com/en/problem/binary-search-tree-iterator/
 * tag: BT nonrecursion travsersal
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
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr;
    //@param root: The root of binary tree.
    public BSTIterator(TreeNode root) {
        this.curr = root;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        return this.curr != null || !stack.isEmpty();
    }
    
    //@return: return next node
    public TreeNode next() {
        while(this.curr != null){
            stack.push(this.curr);
            this.curr = this.curr.left;
        }
        this.curr = stack.pop();
        TreeNode node = this.curr;
        this.curr = this.curr.right;
        return node;
    }
}
