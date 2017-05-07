/**
  * http://www.lintcode.com/en/problem/decode-ways/
*/
public class Solution {
    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        int[] nums = new int[n+1];
        nums[0] = 1;//!!
        nums[1] = s.charAt(0) == '0' ? 0 : 1;
        
        for(int i = 2; i <= n; i++){
            String prevNum = s.substring(i-2, i);
            int prev = Integer.parseInt(prevNum);
            if(s.charAt(i-1) != '0'){
                nums[i] = nums[i-1];
            }
            if(prev >= 10 && prev <= 26){
                nums[i] += nums[i-2];
            }
        }
        
        return nums[n];
    }
}
