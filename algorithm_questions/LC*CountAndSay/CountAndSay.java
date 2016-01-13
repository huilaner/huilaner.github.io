/**
  * difficulty: easy
  * url: https://leetcode.com/problems/count-and-say/
  * tag: String
*/
public class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        String r = "1";
        while(n > 1){
            r = getNextString(r);
            n--;
        }
        return r;
    }
    
    public String getNextString(String s){
        if(s.length() == 0) return "";
        String r = "";
        int i = 0;
        while (i < s.length()){
            char c = s.charAt(i);
            int cnt = 1;
            i++;
            while(i < s.length() && s.charAt(i) == c){
                cnt++;
                i++;
            }
            r += "" + cnt + c ;
        }
        return r;
    }
}
