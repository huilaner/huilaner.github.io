/**
  * difficulty: medium
  * url: https://leetcode.com/problems/unique-binary-search-trees/
  * tag: Tree, DP
*/
public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        if(n < 2) return (n > 0) ? n : 0;
        dp[0] = 0; dp[1]=1; dp[2]=2;
        for(int i = 3; i <= n; i++){
            //chose i, then 1...i-1 are on the left
            //chose n-1, then 1...n-2 are on the left, n on the right
            //chose n-2,  then 1...n-3 are on the left, n, n-1 on the right
            dp[i] = dp[i-1];
            for(int j = 1; j < i; j++){
                if(dp[i-j-1] == 0) dp[i] += dp[j];
                if(dp[j] == 0) dp[i] += dp[i-j-1];
                else dp[i] += dp[i-j-1] * dp[j];
            }
        }
        return dp[n];
    }

}

//To simplify
public class Solution {
    public int numTrees(int n) {
        //G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0) 
        int [] G = new int[n+1];
        G[0] = G[1] = 1;

        for(int i=2; i<=n; ++i) {
            for(int j=1; j<=i; ++j) {
                G[i] += G[j-1] * G[i-j];
            }
        }
    
        return G[n];
    }

}