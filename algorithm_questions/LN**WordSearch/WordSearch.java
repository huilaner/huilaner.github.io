/**
  * difficulty: medium
  * url: http://www.lintcode.com/en/problem/word-search/
  * tag: backtracking
*/
public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        if(board == null || word == null || board.length == 0) return false;
        if(word.length() == 0) return true;
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0) 
                   && findWord(board,i, j,  word, 0)){
                       return true;
                }
            }    
        }
        return false;
    }
    
    private boolean findWord(char[][] board, int i, int j, String word, int start){
        //if(word == null || word.length() == 0) return false;
        if(start == word.length()) return true;
        
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(start)){
            return false;
        }
        
        board[i][j] = '#';//mark as visited
        
        boolean result = findWord(board, i-1, j, word, start+1) 
        || findWord(board, i, j-1, word, start+1)
        || findWord(board, i+1, j, word, start+1)
        || findWord(board, i, j+1, word, start+1);
        
        board[i][j] = word.charAt(start);//change it back
        
        return result;

        
    }
}