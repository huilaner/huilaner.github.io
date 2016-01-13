/**
  * difficulty: easy
  * url: https://leetcode.com/problems/word-pattern/
  * tag: HashTable
*/
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(pattern.length()==1) return true;
        if(str == "" || pattern == "") return false;
        
        String[] ary = str.split(" ");
        HashMap<Character, ArrayList<Integer>> map = new HashMap<Character, ArrayList<Integer>>();
        HashSet<String> usedWords = new HashSet<>();//avoid "abba" "dog dog dog dog"
        
        if(ary.length != pattern.length()) return false;
        
        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            if(!map.containsKey(c)){
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                map.put(c, tmp);
            }else{
                ArrayList<Integer> tmp = map.get(c);
                tmp.add(i);
                map.put(c, tmp);
            }
        }
        
        for(char c : map.keySet()){
            ArrayList<Integer> l = map.get(c);
            String w = ary[l.get(0)];
            if(usedWords.contains(w)) return false;
            usedWords.add(w);
            for(int i = 1; i < l.size(); i++){
                if(!w.equals(ary[l.get(i)])) return false;
            }
        }
        
        return true;
        
    }
}
