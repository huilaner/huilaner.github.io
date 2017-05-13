/**
  * https://www.lintcode.com/en/problem/binary-tree-leaves-order-traversal/#
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
     * @param root the root of binary tree
     * @return collect and remove all leaves
     */
    private int maxLevel = 0;
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(root == null) return rst;
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        getAllDepth(root, map);
        
        for(int i = 0; i <= maxLevel; i++){
            if(map.containsKey(i)){
                rst.add(map.get(i));
            }
        }
        
        return rst;
    }
    
    private int getAllDepth(TreeNode root, HashMap<Integer, List<Integer>> map){
        if(root == null) return 0;
        
        int left = getAllDepth(root.left, map);
        int right = getAllDepth(root.right, map);
        
        int depth = Math.max(left, right) + 1;
        maxLevel = Math.max(maxLevel, depth);
        
        List<Integer> list = (map.containsKey(depth)) ? map.get(depth) : new ArrayList<Integer>();
        list.add(root.val);
        map.put(depth, list);
        return depth;
    }
}
