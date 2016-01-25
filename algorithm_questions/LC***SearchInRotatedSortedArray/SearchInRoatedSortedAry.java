/**
  * difficulty: hard
  * url: https://leetcode.com/problems/search-in-rotated-sorted-array/
  * tag: array, binary search
  * time complexity: O(logN), space: O(1)
*/
public class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        if(nums.length == 1) return (target == nums[0]) ? 0 : -1;
        //find pivot
        int n = nums.length;
        int upperBound = nums[0]; int lowerBound = nums[n-1];
        if(lowerBound > upperBound) return bs(nums, target, 0, n-1);
        //if p < lowerBound in the second half, if p > upperBound in the first half
        //use BS to find pivot
        int L = 0, R = n-1;
        while(L<=R){
            int M = (L+R)/2;
            if(nums[M] >= upperBound) L = M + 1;
            else if(nums[M] <= lowerBound) R = M -1;
            //else break;
        }
        //L is the start
        //use two BFS find the target
        if(target >= nums[0]){//first half
            return bs(nums, target, 0, L-1);
        }else{
            return bs(nums, target, L, n-1);  
        }
        
    }
    
    public int bs(int[]nums, int target, int L, int R){
        if(R == L) return (nums[L] == target) ? L : -1;
        while(L<=R){
            int M = (L+R)/2;
            if(target == nums[M]) return M;
            else if(target < nums[M]) R = M-1;
            else L = M+1;
        }
        return -1;
    }
}