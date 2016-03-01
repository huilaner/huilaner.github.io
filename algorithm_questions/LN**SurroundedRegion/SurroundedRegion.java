public class Solution {
    /**
     * difficulty: medium
     * url: http://www.lintcode.com/en/problem/surrounded-regions/
     * tag: BFS, union find
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
    public void surroundedRegions(char[][] board) {
        // Write your code here
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        
        int row = board.length;
        int col = board[0].length;
        Queue<Integer> cantFlip = new LinkedList<Integer>();
        
        //enqueue the boundary of the board, if there's 'O', then it cannot be flipped
        for(int i = 0; i < row; i++){
            enqueue(board, cantFlip, i, 0);
            enqueue(board, cantFlip, i, col-1);
        }
        for(int j = 1; j < col-1; j++){
            enqueue(board, cantFlip, 0, j);
            enqueue(board, cantFlip, row-1, j);
        }
        
        //if any 'O' is the neighbor of 'D', then cannot be flipped, otherwise can be flipped
        //turn every pos that cannot be flipped
        while(!cantFlip.isEmpty()){
            int idx = cantFlip.poll();
            int x = idx / col;
            int y = idx % col;
            if(board[x][y] == 'O'){
                board[x][y] = 'D';
            }
            //check neighbors
            enqueue(board, cantFlip, x, y-1);
            enqueue(board, cantFlip, x, y+1);
            enqueue(board, cantFlip, x-1, y);
            enqueue(board, cantFlip, x+1, y);
        }
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 'D'){
                    board[i][j] = 'O';
                }
                else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        
    }
    
    private void enqueue(char[][] board, Queue<Integer> q, int i, int j){
        if(i >= 0 && i < board.length && j >= 0 && j < board[0].length
        && board[i][j] == 'O'){
            q.offer(board[0].length * i + j);//2D matrix -> 1D array
        }
        
    }
}
