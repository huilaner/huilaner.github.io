/**
  * difficulty: medium
  * url: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
  * tag: array, 2 pointers
  * time: O(n), space: O(1)
*/
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2) return 2;
        int curr=0, next=1;
        int currNum = Integer.MIN_VALUE;
        while(next < nums.length){
            if(nums[curr] != nums[next]){
                curr++;
                nums[curr] = nums[next];
                next++;
            }else if(nums[curr] != currNum){
                currNum = nums[curr];
                curr++;
                nums[curr] = nums[next];
                next++;
            }else{
               next++; 
            }
        }
        return curr+1;
    }
}
