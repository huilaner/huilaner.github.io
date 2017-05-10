/**
  * http://www.lintcode.com/en/problem/surrounded-regions/#
*/
public class Solution {
    /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
    public void surroundedRegions(char[][] board) {
        //only those O on the edge and its neighbors cannot be flipped
        //find all the pos that cannot be flipper marked by D
        
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        int m = board.length;
        int n = board[0].length;
        Queue<Integer> cantFlip = new LinkedList<>();
        
        for(int i = 0; i < m; i++){
            enqueue(board, cantFlip, i, 0);
            enqueue(board, cantFlip, i, n-1);
        }
        for(int i = 0; i < n; i++){
            enqueue(board, cantFlip, 0, i);
            enqueue(board, cantFlip, m-1, i);
        }
        
        while(!cantFlip.isEmpty()){
            int idx = cantFlip.poll();
            int x = idx / n;
            int y = idx % n;
            if(board[x][y] == 'O'){
                board[x][y] = 'D';
            }
            enqueue(board, cantFlip, x, y+1);
            enqueue(board, cantFlip, x, y-1);
            enqueue(board, cantFlip, x+1, y);
            enqueue(board, cantFlip, x-1, y);
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == 'D'){
                    board[i][j] = 'O';
                }
            }
        }
        
    }
    
    private void enqueue(char[][] board, Queue<Integer> q, int x, int y){
        int m = board.length;
        int n = board[0].length;
        if(x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O'){
            q.offer(x * n + y);
        }
    }

}
