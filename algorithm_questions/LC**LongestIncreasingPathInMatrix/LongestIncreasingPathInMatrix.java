/**
  * difficulty: medium
  * url: https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
  * tag: DP
*/
public class Solution {
    private int[][] dis = {{1,0},{-1,0},{0,1},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        if(matrix.length == 1 && matrix[0].length == 1) return 1;

        int[][] dp = new int[matrix.length][matrix[0].length];
        int res = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                res = Math.max(res, dfs(i,j,matrix,dp) );
            }
        }
        return res;
    }

    private int dfs(int i, int j, int[][] matrix, int[][] dp){
        if(dp[i][j] > 0) return dp[i][j];//visited
        int max = 0;
        for(int k = 0; k < dis.length; k++){
            if(dis[k][0]+i >= 0 && dis[k][0]+i < matrix.length
                && dis[k][1]+j >= 0 && dis[k][1]+j < matrix[0].length
                && matrix[dis[k][0]+i][dis[k][1]+j] > matrix[i][j]){
                max = Math.max(max, dfs(dis[k][0]+i, dis[k][1]+j, matrix, dp));
            }
        }
        dp[i][j] = max+1;
        return dp[i][j];
    }

}
