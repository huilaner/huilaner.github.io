/**
 * difficulty: medium
 * url: http://www.lintcode.com/en/problem/find-the-connected-component-in-the-undirected-graph/
 * tag: BFS, union find
 *
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nodes == null || nodes.size() == 0) return result;
        
        Map<UndirectedGraphNode, Boolean> visited = new HashMap<>();
        
        for(UndirectedGraphNode node : nodes){
            visited.put(node, false);
        }
        
        for(UndirectedGraphNode node : nodes){
            if(!visited.get(node)){
                bfs(result, visited, node);
            }
        }
        
        return result;
    }
    
    private void bfs(List<List<Integer>> result, Map<UndirectedGraphNode, Boolean> visited, UndirectedGraphNode node){
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        q.offer(node);
        List<Integer> list = new ArrayList<Integer>();
        while(!q.isEmpty()){
            UndirectedGraphNode n = q.poll();
            list.add(n.label);
            visited.put(n, true);
            
            for(UndirectedGraphNode v : n.neighbors){
                if(!visited.get(v)){
                    q.offer(v);
                    visited.put(v, true);
                }
            }
        }
        Collections.sort(list);
        result.add(list);
    }
}