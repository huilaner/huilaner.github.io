/**
  * difficulty: easy
  * url: https://leetcode.com/problems/power-of-three/
  * tag: math
*/
public class Solution {
    public boolean isPowerOfThree(int n) {
        return ispower3(n);
        //without loop or recursion: return n>0?(1162261467 / n == 1162261467 / (double)n):0;
        //note: 1162261467 is the largest number of power of 3
    }
    
    public boolean ispower3(int n){
        if (n <= 0) return false;
        if(n == 1) return true;
        if(n % 3 != 0) return false;
        else return ispower3(n/3);
    }
}