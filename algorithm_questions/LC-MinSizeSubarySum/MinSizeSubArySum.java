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

//O(nLogN) method
//the cumulative sum must be strictly increasing. Then, a subarray sum can expressed as the difference between two cumulative sum. Hence, given a start index for the cumulative sum array, the other end index can be searched using binary search.
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) return 0;
        int[] sum = new int[nums.length+1];
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < sum.length; i++) sum[i] = sum[i-1] + nums[i-1];
        for(int i = 0; i < sum.length; i++){
            int end = binarySearch(i, sum.length-1, s+sum[i], sum);
            if(end >= sum.length) break;//out of bound
            min = Math.min(min, end-i);
        }
        return (min == Integer.MAX_VALUE) ? 0 : min;
    }

    private int binarySearch(int L, int R, int t, int[] ary){
        while(L<=R){
            int M = (L+R)/2;
            if(ary[M] >= t) R = M-1;
            else L = M+1;
        }
        return L;
    }
}
