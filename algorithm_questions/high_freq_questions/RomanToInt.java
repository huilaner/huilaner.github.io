/**
  * http://www.lintcode.com/en/problem/roman-to-integer/
*/
public class Solution {
    /**
     * @param s Roman representation
     * @return an integer
     */
    public int romanToInt(String s) {
        if(s == null) return -1;
        int rst = 0;
        int n = s.length();
        if(n == 0) return rst;
        
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1); map.put('V', 5); map.put('X', 10);
        map.put('L', 50); map.put('C', 100); map.put('D', 500);
        map.put('M', 1000);
        
        int prev = 0;
        for(int i = n-1; i >= 0; i--){
            int curr = map.get(s.charAt(i));
            if(i < n-1){
                rst = (prev > curr) ? (rst - curr) : (rst + curr);
            }else{
                rst = curr;
            }
            prev = curr;
        }
        
        return rst;
    }
}
