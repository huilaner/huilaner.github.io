/**
  * difficulty: medium
  * url: https://leetcode.com/problems/maximal-square/
  * tag: DP
*/
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        int max = 0;

        for(int i = 0; i < m; i++){
            dp[i][0] = matrix[i][0]-'0';
            for(int j = 0; j < n; j++){
                dp[0][j] = matrix[0][j]-'0';
                if(i != 0 && j != 0){
                    if(matrix[i][j] == '0') dp[i][j] = 0;
                    else dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]))+1;
                }
                if(max < dp[i][j]) max = dp[i][j];
            }
        }

        return max*max;

    }
}
