/**
  * difficulty: easy
  * url: https://leetcode.com/problems/contains-duplicate-ii/
  * tag: Array, HashTable
  * time complexity: O(n), space: O(k)?
*/
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length < 2 || k < 1) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> currStart = new HashMap<>();
        
        int cnt = k; int i = 0;
        boolean reachedK = false;
        currStart.put(nums[0],0);
        
        while(cnt > 0 && i < nums.length){
            if(map.containsKey(nums[i])) return true;
            if(reachedK){
                int prevVal = currStart.keySet().iterator().next();
                int prevIdx = currStart.remove(prevVal);
                if(map.get(prevVal) == prevIdx) map.remove(prevVal);
                if(prevIdx < nums.length -1) currStart.put(nums[prevIdx+1], prevIdx+1);
            }
            
            map.put(nums[i], i);
            
            cnt--; i++;
            if(cnt <= 0){
                reachedK = true;
                cnt = k;
            }
        }
        
        return false;
    }
}
