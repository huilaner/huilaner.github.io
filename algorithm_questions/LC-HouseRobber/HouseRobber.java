/**
  * difficulty: easy
  * url: https://leetcode.com/problems/house-robber/
  * tag: DP
  * time complexity: O(n), space: O(n)
*/
public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);//pick nums[i] or not
        }
        return dp[n-1];
    }
}
