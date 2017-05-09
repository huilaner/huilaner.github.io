/**
  * http://www.lintcode.com/en/problem/load-balancer/#
*/
public class LoadBalancer {

    private HashMap<Integer, Integer> map;
    private ArrayList<Integer> machines;
    
    public LoadBalancer() {
        map = new HashMap<>();
        machines = new ArrayList<>();
    }

    // @param server_id add a new server to the cluster 
    // @return void
    public void add(int server_id) {
        int size = machines.size();
        machines.add(server_id);
        map.put(server_id, size);
    }

    // @param server_id server_id remove a bad server from the cluster
    // @return void
    public void remove(int server_id) {
        int idx = map.get(server_id);
        if(idx >= machines.size()) return;
        int size = machines.size();
        //need to replace the removed id with the last server
        //otherwise the mapping of the indices will be outdated
        int last_id = machines.get(size-1);
        machines.set(idx, last_id);
        map.put(last_id, idx);
        machines.remove(size-1);
    }

    // @return pick a server in the cluster randomly with equal probability
    public int pick() {
        int size = machines.size();
        Random rand = new Random();
        int idx = Math.abs(rand.nextInt()) % size;
        return machines.get(idx);
    } 
}
