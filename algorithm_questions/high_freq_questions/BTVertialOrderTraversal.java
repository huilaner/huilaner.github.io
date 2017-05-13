/**
  * https://www.lintcode.com/en/problem/binary-tree-vertical-order-traversal/#
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
     * @return the vertical order traversal
     */
    private int maxIdx = 0;
    private int minIdx = 0;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(root == null) return rst;
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        getAllIndex(root, map);
        
        for(int i = minIdx; i <= maxIdx; i++){
            if(map.containsKey(i)){
                rst.add(map.get(i));
            }
        }
        
        return rst;
    }
    
    private void getAllIndex(TreeNode root, HashMap<Integer, List<Integer>> map){
        if(root == null) return;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        HashMap<TreeNode, Integer> idxMap = new HashMap<>();
        idxMap.put(root, 0);
        
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            int idx = idxMap.get(curr);
            maxIdx = Math.max(maxIdx, idx);
            minIdx = Math.min(minIdx, idx);
            
            List<Integer> list = (map.containsKey(idx)) ? map.get(idx) : new ArrayList<Integer>();
            list.add(curr.val);
            map.put(idx, list);
            if(curr.left != null){
                q.add(curr.left);
                idxMap.put(curr.left, idx - 1);
            }
            if(curr.right != null){
                q.add(curr.right);
                idxMap.put(curr.right, idx + 1);
            }
        }
        
        /** dfs way
         * List<Integer> list;
        if(map.containsKey(idx)){
            list = map.get(idx);
        }else{
            list = new ArrayList<Integer>();
        }
        list.add(root.val);
        map.put(idx, list);
        
        maxIdx = Math.max(idx, maxIdx);
        minIdx = Math.min(idx, minIdx);
        
        
        getAllIndex(root.left, idx - 1, map);
        getAllIndex(root.right, idx + 1, map);
        */
    }
}
