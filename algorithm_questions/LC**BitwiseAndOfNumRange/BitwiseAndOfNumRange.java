/**
  * difficulty: meidum
  * url： https://leetcode.com/problems/bitwise-and-of-numbers-range/
  * tag: bit manipulation
*/
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if(m == 0 || n == 0) return 0;
        if(m == n) return m;
        int move = 1;
        while(m != n){
            m >>= 1;
            n >>= 1;
            move <<=1;
        }
        return m*move;
    }
    
}