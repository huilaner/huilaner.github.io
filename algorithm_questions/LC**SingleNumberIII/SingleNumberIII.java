/**
  * difficulty: medium
  * url: https://leetcode.com/problems/single-number-iii/
  * tag: bit manipulation
*/
public class Solution {
    public int[] singleNumber(int[] nums) {
        int[] r = new int[2];
        if(nums.length <2) return r;
        long xor = nums[0];
        for(int i = 1; i < nums.length; i++){
            xor ^= nums[i]; // A^B
        }
        int A = 0; int B = 0;
        //find the first rightmost bit of A^B which means the first rightmost bit differ between A and B and seperate A, B into 2 set
        //use ^ again to get A, B from two sets separately
        //use mask to find the first 0 in xor which means the first bit that A differs from B
        int mask = 1;
        while((mask & xor) == 0){
            mask = mask << 1;
        }
        for(int k : nums){
            if((mask & k) == 0){
                A ^= k;
            }else B ^= k; 
        }
        r[0] = A;
        r[1] = B;
        return r;

    }
}