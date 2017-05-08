/**
  * http://www.lintcode.com/en/problem/first-position-unique-character/#
*/
public class Solution {
    /**
     * @param s a string
     * @return it's index
     */
    public int firstUniqChar(String s) {
        if(s == null) return 0;
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, 1);
            }else{
                map.put(c, map.get(c)+1);
            }
        }
        
        for(int i = 0; i < n; i++){
            if(map.get(s.charAt(i)) == 1) return i;
        }
        
        return -1;
    }
}
