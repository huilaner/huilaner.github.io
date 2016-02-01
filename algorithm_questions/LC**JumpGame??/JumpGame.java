/**
  * difficulty: medium
  * url: https://leetcode.com/problems/jump-game/
  * tag: array, greedy
*/
public class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 0) return false;
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > max) return false;
            max = Math.max(i+nums[i], max);
        }
        return true;
    }

}