/**
  * http://www.lintcode.com/en/problem/edit-distance-ii/#
  * three cases
*/
public class Solution {
    /**
     * @param s a string
     * @param t a string
     * @return true if they are both one edit distance apart or false
     */
    public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null) return false;
        int m = s.length();
        int n = t.length();
        //can be -> if (m > n) return isOneEditDistance(t, s);
        if(m < n){
            String tmp = s;
            s = t;
            t = tmp;
            m = m + n;
            n = m - n;
            m = m - n;
        }
        
        if(m - n > 1) return false;
        boolean oneDiff = false;
        if(m == n){
            for(int i = 0; i < n; i++){
                if(s.charAt(i) != t.charAt(i)){
                    if(!oneDiff) oneDiff = true;
                    else return false;
                }
            }
            if(!oneDiff) return false;
        }
        if(m - n == 1){
            for(int i = 0, j = 0; j < n; i++){
                if(s.charAt(i) != t.charAt(j)){
                    if(!oneDiff){
                        oneDiff = true;
                        continue;
                    }
                    else return false;
                } 
                j++;
            }
            
        }
        
        return true;
    }
}
