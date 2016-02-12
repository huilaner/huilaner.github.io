/**
  * difficulty: medium
  * url: https://leetcode.com/problems/number-of-islands/
  * tag: DFS, BFS, Union Find
*/
public class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int currNum = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1' ){
                    explore(grid, i, j);
                    currNum++;
                }
            }
        }
        return currNum;
    }

    private void explore(char[][] grid, int row, int col){
        grid[row][col] = 'x';
        
            
            if(row-1 >= 0 && grid[row-1][col] == '1') explore(grid, row-1, col);
            if(row+1 < grid.length && grid[row+1][col] == '1') explore(grid, row+1, col);
            if(col-1 >= 0 && grid[row][col-1] == '1') explore(grid, row, col-1);
            if(col+1 < grid[0].length && grid[row][col+1] == '1') explore(grid, row, col+1); 
       

    }


}