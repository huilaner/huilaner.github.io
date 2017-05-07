/**
  * http://www.lintcode.com/en/problem/strings-serialization/#
*/
public class Solution {
    /**
     * @param strs a list of strings
     * @return encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        if(strs == null || strs.size() == 0) return "";
        StringBuilder sb = new StringBuilder();
        
        for(String s : strs){
            String s2 = s.replaceAll(":", "::");
            sb.append(s2+":;");
        }
        
        return sb.toString();
    }

    /**
     * @param str a string
     * @return dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        List<String> rst = new ArrayList<>();
        if(str == null || str.length() == 0) return rst;
        
        int i = 0;
        int n = str.length();
        String curr = "";
        while(i < n){
            if(str.charAt(i) != ':'){
                curr += str.charAt(i);
                i++;
            }else{
                if(i + 1 < n && str.charAt(i+1) == ':'){
                    curr += ':';
                }
                else if(i + 1 < n && str.charAt(i+1) == ';'){
                    rst.add(curr);
                    curr = "";
                }
                i += 2;
            }
        }
        
        return rst;
    }
}
