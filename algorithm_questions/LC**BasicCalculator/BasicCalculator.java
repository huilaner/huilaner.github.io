/**
  * difficulty: medium
  * url: https://leetcode.com/problems/basic-calculator/
  * tag: math. stack
*/
public class Solution {
    public int calculate(String s) {
        s = s.replaceAll(" ","");
        if(s.isEmpty()) return 0;
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        char[] ary = s.toCharArray();
        
        int num = 0;
        int res = 0;
        int sign = 1;
        for(char c : ary){
            if(Character.isDigit(c)) num = num*10 + Integer.parseInt(c+"");
            else if(c == '+' || c == '-'){
                res += sign * num;
                num = 0;
                sign = (c == '+') ? 1 : -1;
            }else if(c == '('){
                numStack.push(res);
                numStack.push(sign);
                //reset sign and result
                sign = 1;
                res = 0;
            }else if(c == ')'){
                res += sign * num;
                num = 0;
                res *= numStack.pop();//is the sign before the parenthesis
                res += numStack.pop();//is the result calculated before the parenthesis
            }
        }
        if(num != 0) res += num * sign;//push the last digit
    

        return res;
    }
    
    
}