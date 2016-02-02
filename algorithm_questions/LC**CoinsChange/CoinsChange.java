/**
  * difficulty: medium
  * url: https://leetcode.com/problems/coin-change/
  * tag: DP
  * ref: http://interactivepython.org/runestone/static/pythonds/Recursion/DynamicProgramming.html
  *
*/
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0) return -1;
        if(amount == 0) return 0;
        Arrays.sort(coins);
        if(amount < coins[0]) return -1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        for(int i = 1; i < amount+1; i++){
            int min = Integer.MAX_VALUE;
            int r = -1;
            for(int j = coins.length-1; j >= 0 && r == -1; j--){
                int c = coins[j];
                if(c == i) r = 1;
                else{
                  int rest = i - c;
                  if(rest > 0 && dp[rest] != -1) min = Math.min(dp[rest]+1, min);  
                }
                
            }
            if(r != -1) dp[i] = r;
            else dp[i] = (min == Integer.MAX_VALUE) ? -1 : min;
        }
        return dp[amount];
    }
}
