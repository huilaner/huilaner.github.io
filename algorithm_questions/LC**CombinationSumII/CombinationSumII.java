/**
  * difficulty: medium
  * url: https://leetcode.com/problems/combination-sum-ii/
  * tag: array, backtracking
*/
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if(candidates.length == 0 || target <= 0) return list;
        List<Integer> currList = new LinkedList<Integer>();
        Arrays.sort(candidates);
        backTrack(candidates, target, 0, currList, list);
        return list;
    }
    
    private void backTrack(int[] ary, int target, int j, List<Integer> currList, List<List<Integer>> list){
        if(target == 0 && currList.size() > 0 && !list.contains(currList)) {
            list.add(new LinkedList<Integer>(currList));
            return;
        }
        if(target < 0) return;
        for(int i = j; i < ary.length; i++){
            //if(i&&num[i]==num[i-1]&&i>order) continue; // check duplicate combination
            if(i > 0 && ary[i]==ary[i-1] && i > j) continue;
            currList.add(ary[i]);
            backTrack(ary, target-ary[i], i+1, currList, list);
            currList.remove(currList.size()-1);
        }
    }
}