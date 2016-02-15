/**
  * difficulty: medium
  * url: https://leetcode.com/problems/repeated-dna-sequences/
  * tag: hashtable, bit manipultation
*/
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        if(s == "" || s.length() <=10) return list;
        
        HashSet<Integer> word = new HashSet<>();
        HashSet<Integer> doubleWord = new HashSet<>();//get rid of duplicate
        int[] map = new int[26];
        map['A'-'A'] = 0;
        map['C'-'A'] = 1;
        map['G'-'A'] = 2;
        map['T'-'A'] = 3;
        //use 4 digit base to do bit manipulation
        for(int i = 0; i < s.length()-9; i++){
            int v = 0;
            for(int j = i; j < i+10; j++){
                v <<= 2;
                v |= map[s.charAt(j)-'A'];
            }
            if(!word.add(v) && doubleWord.add(v)) list.add(s.substring(i, i+10)); // if set contains v, return false
        }
        return list;
    }
}