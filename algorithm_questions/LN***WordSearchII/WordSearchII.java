/**
  * difficulty: hard
  * url: http://www.lintcode.com/en/problem/word-search-ii/#
  * tag: trie tree, search, backtracking
*/
public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        ArrayList<String> result = new ArrayList<>();
        if(board == null || words == null || words.size() == 0){
            return result;
        }
        
        TrieTree tree = new TrieTree(new TrieNode());
        for(String word : words){
            tree.insert(word);
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                findWord(board, tree.root, "", i, j, result);
            }
        }
        
        
        return result;
        
    }

    
    private void findWord(char[][] board, TrieNode node, String candidate, int i, int j, ArrayList<String> result){
        if(node == null) return;

        if(node.isWord && !result.contains(node.word)){
            result.add(node.word);
        }
        //outofbound or visited
        if(i < 0 || j < 0 || i >= board.length || j>= board[0].length
          || board[i][j] == '#'){
              return ;
        }
        
        TrieNode n = node.children[board[i][j]-'a'];
        if(n != null){
            char curr = board[i][j];
            board[i][j] = '#';//visited
            findWord(board, n, candidate, i+1, j, result);
            findWord(board, n, candidate, i-1, j, result);
            findWord(board, n, candidate, i, j-1, result);
            findWord(board, n, candidate, i, j+1, result);
            board[i][j] = curr;
        }
        
    }
}

class TrieTree{
    TrieNode root;
    public TrieTree(TrieNode node){
        root = node;
    }
    public void insert(String word){
        TrieNode n = root;
        for(char c : word.toCharArray()){
            if(n.children[c-'a'] == null){
                n.children[c-'a'] = new TrieNode();
            }
            n = n.children[c-'a'];
        }
        n.word = word;
        n.isWord = true; 
    }
    public boolean find(String s){
        TrieNode n = root;
        for(int i = 0; i < s.length(); i++){
            if(n.children[s.charAt(i)-'a'] == null){
                return false;
            }
            n = n.children[s.charAt(i)-'a'];
        }
        return n.isWord;
    }
}

class TrieNode{
    String word;
    public TrieNode[] children = new TrieNode[26];
    boolean isWord;
    public TrieNode(){}

}