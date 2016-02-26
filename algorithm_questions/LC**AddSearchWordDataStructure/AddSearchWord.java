/**
  * difficulty: medium
  * url: https://leetcode.com/problems/add-and-search-word-data-structure-design/
  * tag: backtracking, trie, design
*/
public class WordDictionary {
    private TrieNode root;
    
    public WordDictionary(){
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode n = root;
        for(char c : word.toCharArray()){
            if(n.children[c-'a'] == null){
                n.children[c-'a'] = new TrieNode();
            }
            n = n.children[c-'a'];
        }
        n.isWord = true;
    }

    private boolean searchHelper(String word, TrieNode node){
        if(word == null || word.length() == 0){
            return true;
        }
        if(word.length() == 1){
        	char c = word.charAt(0);
        	if(c != '.') return node.children[c-'a'] != null && node.children[c-'a'].isWord;
        	else{
        		for(int i = 0; i < 26; i++){
        			if(node.children[i] != null && node.children[i].isWord){
        				return true;
        			}
        		}
        		return false;
        	}
        }
        for(int i = 0; i < word.length(); i++){
            int c = word.charAt(i);
            if(c != '.'){
                if(node.children[c-'a'] == null) return false;
                else return searchHelper(word.substring(1), node.children[c-'a']);
            }else{
                for(int j = 0; j < 26; j++){
                    if(node.children[j] != null && searchHelper(word.substring(1), node.children[j])){
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        TrieNode n = root;
        return searchHelper(word, n);
    }
    
    private class TrieNode{
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
        TrieNode() {};
    }
}





// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");