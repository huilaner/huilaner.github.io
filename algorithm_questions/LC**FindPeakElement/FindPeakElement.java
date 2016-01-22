/**
  * difficulty: medium
  * url: https://leetcode.com/problems/find-peak-element/
  * tag: array, binary search
*/
public class Solution {
    //brute force
    public int findPeakElement(int[] nums) {
        if(nums.length == 0) return -1;
        if(nums.length == 1) return 0;
        for(int i = 1; i < nums.length; i++){
            if(i == 1 && nums[0] > nums[1]) return 0;
            if(i == nums.length-1 && nums[nums.length-1] > nums[nums.length-2]) return nums.length-1;
            if(nums[i-1] < nums[i] && nums[i] > nums[i+1]) return i;
        }
        return -1;
    }
}