/**
  * http://www.lintcode.com/en/problem/integer-to-roman/#
*/
public class Solution {
    /**
     * @param n The integer
     * @return Roman representation
     */
    public String intToRoman(int n) {
        if(n <= 0) return "";
        String rst = "";
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	    for(int i = 0; i < nums.length; i++){
	        int num = n / nums[i];
	        n = n % nums[i];
	        for(int j = 0; j < num; j++){
	            rst += symbols[i];
	        }
	    }
        
        return rst;
    }
}
