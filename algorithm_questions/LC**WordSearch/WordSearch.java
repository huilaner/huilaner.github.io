/**
  * difficulty: medium
  * url: https://leetcode.com/problems/word-search/
  * tag: backtracking, array
*/
//can also use board[y][x] ^= 256; for bit mask to reduce space
public class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.equals("") || board.length == 0) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0) && !visited[i][j]){
                    visited[i][j] = true;
                    if(findWord(board, word.substring(1), i, j, visited)) return true;
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }
    
    private boolean findWord(char[][] board, String word, int i, int j, boolean[][] visited){
        int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
        if(word.equals("")) return true;
        char c = word.charAt(0);
        for(int[] d : delta){
            if(i+d[0] >=0 && i+d[0] < board.length && j+d[1] >= 0 && j+d[1] < board[0].length && c == board[i+d[0]][j+d[1]] && !visited[i+d[0]][j+d[1]]) {
                visited[i+d[0]][j+d[1]] = true;
                if(findWord(board, word.substring(1), i+d[0], j+d[1], visited)) return true;
                else visited[i+d[0]][j+d[1]] = false;
            }
        }
        return false;
    }
}