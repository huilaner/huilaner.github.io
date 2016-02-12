/**
  * difficulty: easy
  * url: https://leetcode.com/problems/nim-game/
  * more details: https://leetcode.com/discuss/63725/theorem-all-4s-shall-be-false
*/
public class Solution {
    public boolean canWinNim(int n) {
        return n%4!=0;

        // followings are using recursion(time out) and DP(memory excceed)...
        // if(n <= 0) return false;
        // if(n <= 3) return true;
        // boolean[] dp = new boolean[n+1];
        // dp[0] = false; dp[1] = true;
        // dp[2] = true; dp[3] = true;
        // for(int i = 4; i <= n; i++){
        //     dp[i] = (!dp[i-1] || !dp[i-2] || !dp[i-3]);
        // }
        // return dp[n];
        // if(n <= 0) return false;
        // if(n <= 3) return true;
        // return !canWinNim(n-1) || !canWinNim(n-2) || !canWinNim(n-3);
    }
}