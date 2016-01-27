/**
  * difficulty: medium
  * url: https://leetcode.com/problems/perfect-squares/
  * tag: DP, BFS, math
  * time: O(N*sqrt(N))??, space: O(N)
*/
public class Solution {
    public int numSquares(int n) {
        if(n <= 0) return 0;
        int[] r = new int[n+1];
        r[0] = 0;
        for(int i = 1; i <= n; i++){
            r[i] = Integer.MAX_VALUE;
            // For each i, it must be the sum of some number (i - j*j) -> r[i-j*j] and 
            // a perfect square number (j*j) - > 1.
            for(int j = 1; j*j <= i; j++){
                r[i] = Math.min(r[i],r[i-j*j]+1);
            }
        }
        return r[n];
    }
}
