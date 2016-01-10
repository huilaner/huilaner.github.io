/**
  * difficulty: easy
  * url: https://leetcode.com/problems/valid-sudoku/
  * tag: HashTable
*/
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0 || board.length != board[0].length
         ||board.length % 3 != 0 || board[0].length % 3 != 0) return false;
         
         //each row
         for(int i = 0; i < board.length; i++){
             if(!check9Digits(board[i])) return false;
         }
         
         //each column
         for(int j = 0; j < board[0].length; j++){
             char[] set = new char[9];
             for(int i = 0; i < board.length; i++){
                 set[i] = board[i][j];
             }
             if(!check9Digits(set)) return false;
         }
         
         //each square
         int n = board.length/3; 
         for(int i = 0; i < n; i++){
             for(int j = 0; j < n; j++){
                char[] set = new char[9];
                set[0] = board[i*3][j*3]; set[1] = board[i*3][j*3+1]; set[2] = board[i*3][j*3+2];
                set[3] = board[i*3+1][j*3]; set[4] = board[i*3+1][j*3+1]; set[5] = board[i*3+1][j*3+2];
                set[6] = board[i*3+2][j*3]; set[7] = board[i*3+2][j*3+1]; set[8] = board[i*3+2][j*3+2];
                if(!check9Digits(set)) return false;
             }
         }
         
         return true;
    }
    
    public boolean check9Digits(char[] set){
        HashMap<Character, Integer> list = new HashMap<>();
        list.put('1',1); list.put('2',1); list.put('3',1);
        list.put('4',1); list.put('5',1); list.put('6',1);
        list.put('7',1); list.put('8',1); list.put('9',1);
        for(char c : set){
            if(c != '.' && !list.containsKey(c)) return false;
            else if(c != '.' && list.containsKey(c)) {
                list.remove(c);
            }
        }
        return true;
    }
}