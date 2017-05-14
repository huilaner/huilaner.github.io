/**
  * https://www.lintcode.com/en/problem/number-of-islands/
*/
public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int cnt = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && grid[i][j]){
                    getAllAdjacent(grid, i, j, visited);
                    cnt++;
                }
                
            }
        }
        
        return cnt;
    }
    
    private void getAllAdjacent(boolean[][] grid, int row, int col, boolean[][] visited){
        visited[row][col] = true;//should put it here!
        
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i = 0; i < 4; i++){
            int x = dx[i] + row;
            int y = dy[i] + col;
            if(x < 0 || x >= m || y < 0 || y >= n) continue;
            if(!visited[x][y] && grid[x][y]){
                getAllAdjacent(grid, x, y, visited);
            }
        }
    }
    

}
