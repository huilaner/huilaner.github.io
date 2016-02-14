/**
  * difficulty: medium
  * url: https://leetcode.com/problems/minimum-height-trees/
  * tag: BFS, graph
  * ref: https://leetcode.com/discuss/71763/share-some-thoughts
*/
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        List<Set<Integer>> adj = new ArrayList<>(n);
        for(int i = 0; i < n; i++) adj.add(new HashSet<Integer>());//init adj
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        //find leaves which only has one adj
        List<Integer> leaves = new ArrayList<>();
        for(int i = 0; i < adj.size(); i++){
            if(adj.get(i).size()==1) leaves.add(i);
        }
        //remove leaves till meet root - should be the two nodes from the longest paths
        while(n>2){
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int i : leaves){
                int j = adj.get(i).iterator().next();//get the only node in the i's adj node set
                adj.get(j).remove(i);
                if(adj.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}