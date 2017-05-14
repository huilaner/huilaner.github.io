/**
  * https://www.lintcode.com/en/problem/nearest-exit/#
  * use dummy as the head of the BFS
*/

class Point{
        public int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
public class Solution {
    /**
     * @param rooms m x n 2D grid
     * @return nothing
     */
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0){
            return;
        }
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<Point> q = new LinkedList<>();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rooms[i][j] == 0){
                    q.add(new Point(i, j));
                }
            }
        }
        
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        
        while(!q.isEmpty()){
           Point p = q.poll();
           for(int i = 0; i < 4; i++){
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                if(isSafe(rooms, x, y) && rooms[x][y] == Integer.MAX_VALUE){
                    q.add(new Point(x, y));
                    rooms[x][y] = rooms[p.x][p.y] + 1;
               }
           }
        }
        
    }
    
    private boolean isSafe(int[][] rooms, int x, int y){
        return (x >= 0 && x < rooms.length && y >= 0 && y < rooms[0].length);
    }
    
    
}

//not use class Point is running a little faster


public class Solution {
    /**
     * @param rooms m x n 2D grid
     * @return nothing
     */
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0){
            return;
        }
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rooms[i][j] == 0){
                    qx.add(i);
                    qy.add(j);
                }
            }
        }
        
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        
        while(!qx.isEmpty()){
           int row = qx.poll();
           int col = qy.poll();
           for(int i = 0; i < 4; i++){
                int x = row + dx[i];
                int y = col + dy[i];
                if(isSafe(rooms, x, y) && rooms[x][y] == Integer.MAX_VALUE){
                    qx.add(x);
                    qy.add(y);
                    rooms[x][y] = rooms[row][col] + 1;
               }
           }
        }
        
    }
    
    private boolean isSafe(int[][] rooms, int x, int y){
        return (x >= 0 && x < rooms.length && y >= 0 && y < rooms[0].length);
    }
    
    
}



