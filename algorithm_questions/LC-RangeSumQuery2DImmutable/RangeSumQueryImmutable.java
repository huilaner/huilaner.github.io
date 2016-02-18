/**
  * difficulty: medium
  * url: https://leetcode.com/problems/range-sum-query-2d-immutable/
  * tag: DP
*/
public class NumMatrix {
    public int[][] sum;

    public NumMatrix(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) sum = null;
        else{
            sum = new int[matrix.length][matrix[0].length];
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[0].length; j++){
                    sum[i][j] = matrix[i][j];
                    sum[i][j] += (j >= 1) ? sum[i][j-1] : 0;
                    sum[i][j] += (i >= 1) ? sum[i-1][j] : 0;
                    sum[i][j] -= (i>=1 && j>=1) ? sum[i-1][j-1] : 0;
                    //System.out.println("i:"+i+" j:"+j+" sum:"+sum[i][j]);
                }
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(this.sum == null) return 0;
        if(row1 >= this.sum.length || row2 >= this.sum.length ||
                col1 >= this.sum[0].length || col2 >= this.sum[0].length) return 0;
        int r = this.sum[row2][col2];
        r -= (row1 >=1) ? this.sum[row1-1][col2] : 0;
        r -= (col1 >=1) ? this.sum[row2][col1-1] : 0;
        r += (row1 >=1 && col1 >=1) ? this.sum[row1-1][col1-1] : 0;
        return r;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
