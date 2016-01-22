/**
  * difficulty: medium
  * url: https://leetcode.com/problems/combinations/
  * tag: backtracking
*/
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if(n == 0) return list;
        LinkedList<Integer> curr = new LinkedList<Integer>();
        dfs(n, k, 1, curr, list);
        
        return list;
    }
    
    public void dfs(int n, int k, int start, LinkedList<Integer> item, List<List<Integer>> res){
        if(item.size() ==  k){
            res.add(new LinkedList<Integer>(item));//deep copy
            return;
        }
        for(int i = start; i < n+1; i++){
            item.add(i);
            dfs(n, k, i+1, item, res);
            item.remove(item.size()-1);//remove the last el???
        }

    }
}
