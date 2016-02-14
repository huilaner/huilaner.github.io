/**
  * difficulty: medium
  * url: https://leetcode.com/problems/implement-trie-prefix-tree/
  * tag: tries, design
*/
class TrieNode {
    // Initialize your data structure here.
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {}
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode n = root;
        for(char c : word.toCharArray()){
            if(n.children[c-'a'] == null) n.children[c-'a'] = new TrieNode();
            n = n.children[c-'a'];
        }
        n.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode n = root;
        for(char c : word.toCharArray()){
            if(n.children[c-'a'] == null) return false;
            else n = n.children[c-'a'];
        }
        return n.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode n = root;
        for(char c : prefix.toCharArray()){
            if(n.children[c-'a'] == null) return false;
            else n = n.children[c-'a'];
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");