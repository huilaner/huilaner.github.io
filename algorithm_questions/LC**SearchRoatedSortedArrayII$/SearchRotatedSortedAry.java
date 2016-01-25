/**
  * difficulty: medium
  * url: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
  * tag: binary search
  * time complexity: O(N), space: O(1)
*/
public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0) return false;
        if(nums.length == 1) return (target == nums[0]);
        //find pivot
        int n = nums.length;
        int L = -1;
        for(int i = 1; i < n; i++){
            if(nums[i] < nums[i-1]) L = i;
            if(L != -1) break;
        }
        if(L == -1) return bs(nums, target, 0, n-1);
        //L is the start
        //use two BFS find the target
        if(target == nums[0]) return true;
        if(target >nums[0]){//first half
            return bs(nums, target, 0, L-1);
        }else{
            return bs(nums, target, L, n-1);  
        }
        
    }
    
    public boolean bs(int[]nums, int target, int L, int R){
        //System.out.println("L:"+L+" R:"+R);
        if(R == L) return (nums[L] == target);
        while(L<=R){
            int M = (L+R)/2;
            if(target == nums[M]) return true;
            else if(target < nums[M]) R = M-1;
            else L = M+1;
        }
        return false;
    }

}

//log(N) solutions
public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0) return false;
        if(nums.length == 1) return (target == nums[0]);
        //find pivot
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = l + (r - l)/2;
            if (nums[m] == target) return true; //return m in Search in Rotated Array I
            if (nums[l] < nums[m]) { //left half is sorted
                if (nums[l] <= target && target < nums[m])
                    r = m - 1;
                else
                    l = m + 1;
            } else if (nums[l] > nums[m]) { //right half is sorted
                if (nums[m] < target && target <= nums[r])
                    l = m + 1;
                else
                    r = m - 1;
            } else l++;
        }
        return false;
    }

}