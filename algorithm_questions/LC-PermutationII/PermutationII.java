/**
  * difficulty: medium
  * url: https://leetcode.com/problems/permutations-ii/
  * tag: backtracking
*/
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if(nums.length == 0) return list;
        List<Integer> currList = new LinkedList<Integer>();
        list.add(currList);

        for(int i = 0; i < nums.length; i++){
            List<List<Integer>> curr = new LinkedList<List<Integer>>();
            for(List<Integer> l : list){
                for(int j = 0; j < l.size()+1; j++){
                    l.add(j,nums[i]);
                    List<Integer> newList = new LinkedList<Integer>(l);
                    l.remove(j);
                    if(!curr.contains(newList)) curr.add(newList);
                }
            }
            list = new LinkedList<List<Integer>>(curr);
        }

        return list;
    }
}


public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if(nums.length == 0) return list;
        Arrays.sort(nums);

        List<Integer> currList = new LinkedList<Integer>();
        boolean[] visited = new boolean[nums.length];

        permute(nums, visited, currList, list);

        return list;
    }

    private void permute(int[] nums, boolean[] visited, List<Integer> currList, List<List<Integer>> list){
        if(currList.size() == nums.length-1){
            list.add(new LinkedList<Integer>(currList));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!visited[i]){
                if(i>0 && nums[i] == nums[i-1] && visited[i-1]) return;
                visited[i] = true;
                currList.add(nums[i]);
                permute(nums, visited, currList, list);
                currList.remove(currList.size()-1);
                visited[i] = false;
            }
        }

    }
}
