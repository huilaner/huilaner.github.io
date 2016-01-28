/**
  * difficulty: medium
  * url: https://leetcode.com/problems/house-robber-ii/
  * tag: DP
  * time: O(n), space:O(1)
*/
public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        //Rob houses 0 to n - 2; or Rob houses 1 to n - 1.
        return Math.max(helper(nums, 0, nums.length-2), helper(nums, 1, nums.length-1));
    }
    
    private int helper(int[] nums, int L, int R) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int prevNo = 0, prevYes = 0;
        for(int i = L; i <= R; i++){
            int tmp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = tmp + nums[i];
        }
        return Math.max(prevNo, prevYes);
    }
}
