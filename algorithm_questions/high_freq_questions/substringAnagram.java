/**
  * http://www.lintcode.com/en/problem/substring-anagrams/#
*/
public class Solution {
    /**
     * @param s a string
     * @param p a non-empty string
     * @return a list of index
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList <Integer>();
        int[] sum = new int[30];

        int plength = p.length(), slength = s.length();
        for(char c : p.toCharArray()){
            sum[c - 'a'] ++;
        }
        
        int start = 0, end = 0, matched = 0;
        while(end < slength){
            if(sum[s.charAt(end) - 'a'] >= 1){
                matched ++;
            }
            sum[s.charAt(end) - 'a'] --;
            end ++;
            if(matched == plength) {
                ans.add(start);
            }
            if(end - start == plength){
                if(sum[s.charAt(start) - 'a'] >= 0){
                    matched --;
                }
                sum[s.charAt(start) - 'a'] ++;
                start ++;
            }
        }
        return ans;
    }
    

}
