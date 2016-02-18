/**
  * difficulty: medium
  * url: https://leetcode.com/problems/multiply-strings/
  * tag: math, string
*/
public class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        if(num1.equals("1")) return num2;
        if(num2.equals("1")) return num1;
        if(num1.length() < num2.length()){
            String tmp = num2;
            num2 = num1;
            num1 = tmp;
        }
        int n = num2.length();
        String[] add = new String[n+1];//the last is the sum
        
        //multiply - reversed
        StringBuilder sb = new StringBuilder();
        for(int i = n-1; i >=0; i--){
            int carry = 0;
            sb = new StringBuilder();
            for(int j = num1.length()-1; j >= 0; j--){
                int calc = (num1.charAt(j)-'0') * (num2.charAt(i)-'0') + carry;
                carry = calc / 10;
                sb.append(calc % 10);
            }
            if(carry != 0) sb.append(carry);
            add[n-1-i] = sb.toString();
        }
        
        //add
        sb = new StringBuilder();
        int max = n-1+add[n-1].length();
        int carry = 0;
        for(int i = 0; i < max; i++){
            int sumAtI = carry;
            for(int j = 0; j < n; j++){
                if(i-j >=0 && i-j < add[j].length()) sumAtI += add[j].charAt(i-j)-'0';
            }
            carry = sumAtI/10;
            sb.append(sumAtI%10+"");
        }
        if(carry != 0) sb.append(carry+"");
        
        
        return sb.reverse().toString();
    }
}
