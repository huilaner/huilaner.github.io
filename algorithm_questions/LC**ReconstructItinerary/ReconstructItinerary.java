/**
  * difficulty: medium
  * url: https://leetcode.com/problems/reconstruct-itinerary/
  * tag: DFS, graph
*/
public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> list = new ArrayList<>();
        if(tickets.length == 0) return list;
        HashMap<String, PriorityQueue<String>> map = new HashMap<String,PriorityQueue<String>>();

        for(String[] t : tickets){
            if(map.containsKey(t[0])) map.get(t[0]).add(t[1]);
            else{
                PriorityQueue<String> set = new PriorityQueue<>();
                set.add(t[1]);
                map.put(t[0], set);
            }

        }
        dfs(map, list, "JFK");
        return list;
    }

    private void dfs(HashMap<String, PriorityQueue<String>> map, List<String> list, String start){
        while(map.containsKey(start) && !map.get(start).isEmpty()){
            String dest = map.get(start).poll();
            dfs(map, list, dest);
        }
        list.add(0,start);
        
    }
}
