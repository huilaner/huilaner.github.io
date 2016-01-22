/**
  * difficulty: medium
  * url: https://leetcode.com/problems/permutations/
  * tag: backtracking
*/
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if(nums.length == 0) return list;
        List<Integer> p = new LinkedList<Integer>();
        list.add(p);
        for(int i = 0; i < nums.length; i++){
            List<List<Integer>> curr = new LinkedList<List<Integer>>();
            for(List l : list){
                for(int j = 0; j < l.size()+1; j++){
                    l.add(j, nums[i]);
                    List tmp = new LinkedList(l);
                    curr.add(tmp);
                    l.remove(j);
                    
                }
            }
            list = new LinkedList<List<Integer>>(curr);
        }
        return list;
    }
    

}