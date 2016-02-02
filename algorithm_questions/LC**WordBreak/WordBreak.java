/**
  * difficulty: medium
  * url: https://leetcode.com/problems/word-break/
  * tag: DP
*/
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s.length() == 0 || wordDict.size() == 0) return false;
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && wordDict.contains(s.substring(j, i))) dp[i] = true;
            }
        }
        return dp[s.length()];
    }
}