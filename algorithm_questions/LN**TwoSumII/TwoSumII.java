/**
  * difficulty: medium
  * url: http://www.lintcode.com/en/problem/two-sum-ii/
  * tag: 2 pointers
*/
public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        // Write your code here
        if(nums.length == 0) return 0;
        int left = 0; 
        int right = nums.length - 1;
        Arrays.sort(nums);
        int cnt = 0;
        while(left <= right){
            int sum = nums[left] + nums[right];
            if(sum <= target) {
                left++;
            }else{
                cnt += right - left;
                right--;
            }
        }
        return cnt;
    }
}