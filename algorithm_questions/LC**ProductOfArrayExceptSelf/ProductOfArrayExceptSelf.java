/**
  * difficulty: medium
  * url: https://leetcode.com/problems/product-of-array-except-self/
  * tag: array
*/
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ary = new int[nums.length];
        if(nums.length <= 1) return ary;
        int p = 1;
        ary[0] = 1;
        //let [1,a1,a1*a2,a1*a2*a3] and [a2*a3*a4,a3*a4,a4,1] multiply
        for(int i = 1; i < nums.length; i++){
            p = p * nums[i-1];
            ary[i] = p;
        }
        p = 1;
        for(int i = nums.length -1; i > 0; i--){
            p = p * nums[i];
            ary[i-1] *= p;
        }
        return ary;
    }
}