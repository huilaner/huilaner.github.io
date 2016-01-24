/**
  * difficulty: medium
  * url: https://leetcode.com/problems/set-matrix-zeroes/
  * tag: array
  * time complexity: O(N^2), space: O(N^2)
*/
//brute force
public class Solution {
    public void setZeroes(int[][] matrix) {
        //since if set directly on the matrix will affect the following element and result
        //use a tmp matrix
        int m = matrix.length; int n = matrix[0].length;
        if(m == 0 || n == 0) return;
        int[][] tmp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    markZero(tmp, i, j);
                }
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(tmp[i][j] == 1) matrix[i][j] = 0;
            }
        }
    }
    //passing by reference's value
    public void markZero(int[][] tmp, int i, int j){
        //vertical
        for(int k = 0; k < tmp.length; k++){
            tmp[k][j] = 1;
        }
        //horizontal
        for(int k = 0; k <  tmp[0].length; k++){
            tmp[i][k] = 1;
        }
    }
}

// use space: 0(1)
public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length; int n = matrix[0].length;
        if(m == 0 || n == 0) return;

        //store status for each row/column in the 0th el, for[0,0] set col0 to store 0th column
        //top-bottom count zeros
        int col0 = -1;
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0) col0 = 0;
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        //bottom-top convert matrix
        for(int i = m - 1; i >= 0; i--){
            for(int j = n-1; j > 0; j--){
                if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
            if(col0 == 0) matrix[i][0] = 0;
        }
        
    }

}