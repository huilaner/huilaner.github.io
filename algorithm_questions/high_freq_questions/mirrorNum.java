/**
  * http://www.lintcode.com/en/problem/mirror-numbers/#
*/
public class Solution {
    /**
     * @param num a string
     * @return true if a number is strobogrammatic or false
     */
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.isEmpty()) return true;
        HashMap<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        
        int n = num.length();
        int l = 0, r = n - 1;
        while(l <= r){
            char lc = num.charAt(l);
            char rc = num.charAt(r);
            if(!map.containsKey(lc) || map.get(lc) != rc){
                return false;
            }
            l++; r--;
        }
        
        return true;
    }
}
