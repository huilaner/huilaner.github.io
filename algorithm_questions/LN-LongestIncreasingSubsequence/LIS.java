/**
  * difficulty: medium
  * url: http://www.lintcode.com/en/problem/longest-increasing-subsequence/
  * tag: DP
*/
public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 0;
        
        for(int i = 1; i < n; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] <= nums[i]){
                   dp[i] = Math.max(dp[i], dp[j]+1); 
                }
            }
            if(dp[i] > max) max = dp[i];
        }

        return max;
    }
}
