/**
  * difficulty: meidum
  * url: https://leetcode.com/problems/search-a-2d-matrix/
  * tag: arryay, binary search
*/
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        //first search which row
        int L = 0; int R = matrix.length-1;
        while(L<R){
            int M = (L+R)/2;
            if(target == matrix[M][0]) return true;
            else if(target > matrix[M][0]) L = M+1;
            else R = M;
        }
        R = matrix[L].length-1;
        if(L > 0 && matrix[L-1][R] >= target) L = L-1;
        int row = L;
        L = 0; 
        while(L < R){
            int M = (L+R)/2;
            if(target == matrix[row][M]) return true;
            else if(target > matrix[row][M]) L = M+1;
            else R = M;
        }
        if(target == matrix[row][L]) return true;
        return false;
    }
    

}