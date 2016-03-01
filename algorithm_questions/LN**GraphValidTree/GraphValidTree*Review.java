public class Solution {
    /**
     * difficulty: medium
     * url: http://www.lintcode.com/en/problem/graph-valid-tree/
     * tag: union find, graph
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        if(edges.length != n - 1){
            return false;
        }
        int[] parents = new int[n];
        for(int i = 0; i < n; i++){
            parents[i] = i;
        }
        for(int[] edge : edges){
            if(find(parents, edge[0]) == find(parents, edge[1])){
                return false;
            }
            union(parents, edge[0], edge[1]);
        }
        
        return true;
    }
    
    private int find(int[] parents, int child){
        int p = parents[child];
        while(p != parents[p]){
            p = parents[p];
        }
        return p;
    }
    
    private void union(int[] parents, int c1, int c2){
        int p1 = find(parents, c1);
        int p2 = find(parents, c2);
        parents[p1] = p2;
    }
}
