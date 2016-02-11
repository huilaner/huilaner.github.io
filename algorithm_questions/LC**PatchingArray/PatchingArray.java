/**
  * difficulty: medium
  * url: https://leetcode.com/problems/patching-array/
  * tag: greedy
  * ref: https://leetcode.com/discuss/82822/solution-explanation
*/
public class Solution {
/*Let miss be the smallest sum in [0,n] that we might be missing. 
    Meaning we already know we can build all sums in [0,miss). 
Then if we have a number num <= miss in the given array, 
we can add it to those smaller sums to build all sums in [0,miss+num). 
If we don't, then we must add such a number to the array, 
and it's best to add miss itself, to maximize the reach.*/
    public int minPatches(int[] nums, int n) {
        if(n == 0) return 0;
        long miss = 1;
        int i = 0, added = 0;
        
        while(miss <= n){
            if(i < nums.length && nums[i] <= miss){
                miss += nums[i];
                i++;
            }else{
                miss += miss;
                added++;
            }
        }
        return added;
    }
}