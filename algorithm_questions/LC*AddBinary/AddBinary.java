/**
  * difficulty: easy
  * url: https://leetcode.com/problems/add-binary/
  * tag: Math, String
*/
public class Solution {
    public String addBinary(String a, String b) {
        if(a.length() == 0) return b;
        if(b.length() == 0) return a;
        int carryOn = 0;
        StringBuilder sb = new StringBuilder();

        String s1 = (a.length() < b.length()) ? a : b;
        String s2 = (a.length() < b.length()) ? b : a;
        int i = 0;
        for(; i < s1.length(); i++){
            int sum = (s1.charAt(s1.length() - i - 1) - '0') + (s2.charAt(s2.length() - i - 1) - '0') + carryOn;
            if(sum > 1){
                sum -= 2;
                carryOn = 1;
            }else carryOn = 0;

            sb.append(sum);
        }
        for(int j = s2.length() - s1.length()-1; j >= 0 ; j--){
            int sum = (s2.charAt(j) - '0') + carryOn;
            if(sum > 1){
                sum -= 2;
                carryOn = 1;
            }else carryOn = 0;

            sb.append(sum);
        }

        if(carryOn == 1) sb.append("1");
        
        return sb.reverse().toString();
    }
}
