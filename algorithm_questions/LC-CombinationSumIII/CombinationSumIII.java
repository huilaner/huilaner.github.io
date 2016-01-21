/**
  * difficulty: medium
  * url: https://leetcode.com/problems/combination-sum-iii/
  * tag: backtracking
*/
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if(k == 0 || n <= 0 || (k == 1 && n > 9)) return list;
        LinkedList<Integer> curr = new LinkedList<Integer>();
        dfs(k, n, 1, 0, curr, list);
        return list;
    }
    
    public void dfs(int k, int n, int start, int sum, LinkedList<Integer> item, List<List<Integer>> res){
        if(n == sum && item.size() == k){
            res.add(new LinkedList<Integer>(item));
            return;
        }

        for(int i = start; i < 10; i++){
            item.add(i);
            dfs(k, n, i+1, sum+i, item, res);
            item.remove(item.size()-1);
            
        }
    }
}
