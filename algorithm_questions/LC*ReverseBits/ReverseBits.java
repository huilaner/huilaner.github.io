/**
  * difficulty: easy
  * url: https://leetcode.com/problems/reverse-bits/
  * tag: bit manipulation
*/
public class Solution {
    // you need treat n as an unsigned value
    /**
     * given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
     * Mask moves 1 bit each time using << operation.
        Mask can be computed and saved before to speed up the reverse function.
        
        E.g. 
        iteration 1:  mask = 0000...00001,  then mask & n  = 0
        iteration 2:  mask = 0000...00010, then mask & n  = 0
        iteration 3:  mask = 0000...00100,  then mask & n  = 1
        iteration 4:  mask = 0000...01000, then mask & n  = 1
        ...
        iteration 32:  mask = 1000...00000, then mask & n  = 0
    */
    public int reverseBits(int n) {
        if(n == 0) return n;
        int mask = 1;
        int result = 0;
        for(int i = 0; i < 32; i++){
            int curr = n & mask;
            if (curr != 0) result++;
            if (i!=31) result <<= 1;
            mask <<= 1;
        }
        return result;
    }
}