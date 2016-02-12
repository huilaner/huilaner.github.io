/**
  * difficulty: medium
  * url: https://leetcode.com/problems/minimum-size-subarray-sum/
  * tag: array, 2pointer, binary tree
*/
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) return 0;
        int min = Integer.MAX_VALUE, start = 0, end = 0, sum = 0;
        while(end < nums.length){
            // System.out.println("end:"+nums[end]);
            sum += nums[end++];
            while(sum >= s){
                // System.out.println("start:"+nums[start]);
                min = Math.min(min, end-start);
                sum -= nums[start++];
                // System.out.println("sum:"+sum+" min:"+min);
            }
        }
        return (min == Integer.MAX_VALUE) ? 0 : min;
    }
}
