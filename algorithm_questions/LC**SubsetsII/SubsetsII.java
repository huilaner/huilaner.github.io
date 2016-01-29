/**
  * difficulty: medium
  * url: https://leetcode.com/problems/subsets-ii/
  * tag: array, backtracking
  * time: ? space: ?
*/
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        int n = nums.length;
        if(n == 0) return list;
        Arrays.sort(nums);
        List<Integer> l = new LinkedList<>();
        list.add(l);
        int times = 0; int replicate = Integer.MAX_VALUE;
        for(int i =  0; i < n; i++){
            int k = list.size();
            if(replicate != nums[i]){
                replicate = nums[i];
                times = 0;
            }
            else times++;
            for(int j = 0; j < k; j++){
                List<Integer> tmp = new LinkedList<Integer>(list.get(j));
                if(times == 0){
                    tmp.add(nums[i]);
                    list.add(tmp);
                }else if(times > 0 && !tmp.contains(replicate)){
                    for(int m = 0; m <= times; m++){tmp.add(replicate);}
                    list.add(tmp);
                }
            }
        }
        return list;
    }
}
