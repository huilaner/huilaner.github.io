/**
 * difficulty: medium
 * url: http://www.lintcode.com/en/problem/find-the-weak-connected-component-in-the-directed-graph/
 * tag: union find
 *
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Directed graph node
     * @return a connected set of a directed graph
     */
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nodes == null || nodes.size() == 0){
            return result;
        }
        HashMap<Integer, Integer> father = new HashMap<>();
        //put all nodes into father, assume father is theirselves
        for(DirectedGraphNode node : nodes){
            father.put(node.label, node.label);
            for(DirectedGraphNode n : node.neighbors){
                father.put(n.label, node.label);
            }
        }
        
        for(DirectedGraphNode node : nodes){
            for(DirectedGraphNode n : node.neighbors){
                union(father, node.label, n.label);
            }
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for(int child : father.keySet()){
            int parent = find(father,child);
            if(map.containsKey(parent)){
                result.get(map.get(parent)).add(child);
            }else{
                map.put(parent,index);
                List<Integer> list = new ArrayList<Integer>();
                list.add(child);
                result.add(list);
                index++;
            }
        }
        
        for(List<Integer> list : result){
            Collections.sort(list);
        }
        
        return result;
        
    }
    

    private int find(HashMap<Integer, Integer> father, int x){
        int p = father.get(x);
        while(p != father.get(p)){
            p = father.get(p);
        }
        return p;
    }
    
    private void union(HashMap<Integer, Integer> father, int x1, int x2){
        int p1 = find(father, x1);
        int p2 = find(father, x2);
        
        if(p1 != p2){
            father.put(p1, p2);
        }
    }
}