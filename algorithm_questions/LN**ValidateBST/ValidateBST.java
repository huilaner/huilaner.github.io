/**
  * difficulty: medium
  * url: http://www.lintcode.com/en/problem/validate-binary-search-tree/
  * tag: BST
*/
class ReturnValue{
        public boolean isBST;
        public int max;
        public int min;
        public ReturnValue(boolean isbst, int max, int min){
            this.isBST = isbst;
            this.max = max;
            this.min = min;
        }
    }

public class Solution {
    // private int lastVal = Integer.MIN_VALUE;
    // private boolean firstNode = true;
    
    public boolean isValidBST(TreeNode root) {
        ReturnValue r = validHelper(root);  
        return r.isBST;
    }
    
    private ReturnValue validHelper(TreeNode root){
        if(root == null) return new ReturnValue(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        ReturnValue left = validHelper(root.left);
        ReturnValue right = validHelper(root.right);
        
        if(!left.isBST || !right.isBST) return new ReturnValue(false,0,0);
        if((root.left != null && left.max >= root.val) || (root.right != null && right.min <= root.val)) return new ReturnValue(false,0,0);
        
        return new ReturnValue(true, Math.max(root.val,right.max), Math.min(left.min, root.val));
    }
    
    
}