/**
  * difficulty: medium
  * url: https://leetcode.com/problems/maximum-product-of-word-lengths/
  * tag: bit manipulation
*/
public class Solution {
    public int maxProduct(String[] words) {
        if(words.length <= 1) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(String w : words){
            int bits = char2Bit(w);
            if(!map.containsKey(bits) || (map.containsKey(bits) && w.length() > map.get(bits))){
                map.put(bits, w.length());
            }
        }
        if(map.size() == 1) return 0;
        int result = 0;
        for(int k1 : map.keySet()){
            for(int k2: map.keySet()){
                int curr = map.get(k1)*map.get(k2);
                if((k1 & k2) == 0 &&  curr > result){
                    result = curr;
                }
            }
        }
        return result;
    }
    
    private int char2Bit(String s){
        if(s == "") return 0;
        int r = 0; 
        for(char c : s.toCharArray()){
            int currBit = 1 << (int)(c - 'a');
            r |= currBit;
        }
        return r;
    }
}

// optimize the way to store the bits
public class Solution {
    public int maxProduct(String[] words) {
        if(words.length <= 1) return 0;
        int[] bits = new int[words.length];
        for(int i = 0; i < words.length; i++){
            bits[i] = char2Bit(words[i]);
        }
        int max = 0;
        for(int i = 0; i < words.length; i++){
            for(int j = i+1; j < words.length; j++){
                if((bits[i] & bits[j]) == 0){
                    max = Math.max(max, words[i].length()*words[j].length());
                }
            }
        }
        return max;
    }
    
    private int char2Bit(String s){
        if(s == "") return 0;
        int r = 0; 
        for(char c : s.toCharArray()){
            int currBit = 1 << (int)(c - 'a');
            r |= currBit;
        }
        return r;
    }
}