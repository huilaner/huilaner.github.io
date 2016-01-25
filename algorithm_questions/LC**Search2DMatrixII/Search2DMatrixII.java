/**
  * difficulty: medium
  * url: https://leetcode.com/problems/search-a-2d-matrix-ii/
  * tag: divide and conquer, binary search
  * *optimized solution after saw in disucussion
  * time complexity: O(m+n), space: O(1)
*/
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        //search from top right el
        int m = matrix.length; int n = matrix[0].length;
        int row = 0, col = n-1;
        while(col >= 0 && row < m){
            if(matrix[row][col] == target) return true;
            else if(target < matrix[row][col]) col--;
            else if(target > matrix[row][col]) row++;
        }
        
        return false;
    }
}

// use recursion and Binary search
// time: O(mlogN), space: O(M)?
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length; int n = matrix[0].length;
    
        return searchMatrix(matrix, target, 0, m-1, n);
    }
    
    public boolean searchMatrix(int[][] matrix, int target, int top, int bottom, int n){
        if(top > bottom) return false;
        int M = (top+bottom)/2;
        if(matrix[M][0] <= target && matrix[M][n-1] >= target){
            if(searchRow(matrix[M], target)) return true;
        }
        if(searchMatrix(matrix, target, top, M-1, n)) return true;
        if(searchMatrix(matrix, target, M+1, bottom, n)) return true;
        return false;
    }
    
    public boolean searchRow(int[] row, int target){
        int L = 0, R = row.length-1;
        while(L<=R){
            int M = (L+R)/2;
            if(target == row[M]) return true;
            else if(target > row[M]) L = M+1;
            else R = M-1;
        }
        return false;
    }
}