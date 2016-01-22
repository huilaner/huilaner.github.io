/**
  * difficulty: medium
  * url: https://leetcode.com/problems/missing-number/
  * tag: array, math, bit manipulation
*/
public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        for(int i : nums){
            sum -= i;
        }
        return sum;
    }
}

// 2. using bit manipulation
public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int r = 0;
        //using a^b^b =a
        int i = 0;
        for(; i < nums.length; i++){
            r = r ^ i ^ nums[i];
        }
        return r ^ i;
    }
}