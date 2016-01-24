/**
  * difficulty: medium
  * url: https://leetcode.com/problems/bulb-switcher/
  * tag: math, brainteaser
*/
//this solution is time out
public class Solution {
    public int bulbSwitch(int n) {
        if(n == 0) return 0;
        //excpet for the first one
        int sum = 1;
        for(int i = 1; i < n; i++){
            sum += (ifOn(i, n)) ? 1 : 0;
        }
        return sum;
    }
    
    public boolean ifOn(int i, int n){
        int sum = 0;
        for(int r = 2; r <= n; r++){
            sum += ((i+1)%r == 0) ? 1 : 0;
        }
        //sum is even: on, sum is odd: off
        return sum % 2 == 0;
    }
}

/**
  * actually sum above, bulb ends up on iff switched odd times
  * bulb i switched at round d, iff d%i == 0
  * divisors come in pairs, except when i is a square (sqrt is the only divisor for the pair, so the sum of divisor is odd)
  * then problem -> count #square -> sqrt(n)
*/
public class Solution {
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}
