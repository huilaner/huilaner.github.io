/**
  * difficulty: meidum
  * url: https://leetcode.com/problems/game-of-life/
  * tag: array
*/
//brute force
public class Solution {
    public void gameOfLife(int[][] board) {
        if(board.length == 0 || board[0].length == 0) return;
        int m = board.length; int n = board[0].length;
        int[][] nextBoard = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                nextBoard[i][j] = getStatus(board, i, j);
            }
        }

        for(int i = 0; i < m; i++){
            board[i] = Arrays.copyOf(nextBoard[i], n);
        }
        // System.out.println("board:"+board[0][0]);
    }
    public int getStatus(int[][] board, int i, int j){
        System.out.println("in:"+board[0][0]+" nei:"+getLiveNeighborNum(board, i, j));
        //Any live cell with fewer than two live neighbors dies, as if caused by under-population.
        if(board[i][j] == 1 && getLiveNeighborNum(board, i, j) < 2) return 0;
        //Any live cell with two or three live neighbors lives on to the next generation.
        else if(board[i][j] == 1 && (getLiveNeighborNum(board, i, j) == 2 ||getLiveNeighborNum(board, i, j) == 3) ) return 1;
        //Any live cell with more than three live neighbors dies, as if by over-population.
        else if(board[i][j] == 1 && getLiveNeighborNum(board, i, j) > 3) return 0;
        //Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
        else if(board[i][j] == 0 && getLiveNeighborNum(board, i, j) == 3) return 1;
        
        return 0;
    }
    
    public int getLiveNeighborNum(int[][] board, int i, int j){
        int r = 0;
        //horizontal
        r += (i-1 >= 0) ? board[i-1][j] : 0;
        r += (i+1 < board.length) ? board[i+1][j] : 0;
        //vertical
        r += (j-1 >= 0) ? board[i][j-1] : 0;
        r += (j+1 < board[0].length) ? board[i][j+1] : 0;
        //diagnal
        r += (i-1 >= 0 && j-1 >= 0) ? board[i-1][j-1] : 0;
        r += (i+1 < board.length && j-1 >= 0) ? board[i+1][j-1] : 0;
        r += (i-1 >= 0 && j+1<board[0].length) ? board[i-1][j+1] : 0;
        r += (i+1 < board.length && j+1 < board[0].length) ? board[i+1][j+1] : 0;
        // System.out.println("r:"+r);
        return r;
    }
}