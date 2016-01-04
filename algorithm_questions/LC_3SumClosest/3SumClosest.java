/**
 * difficulty: medium
 * url: https://leetcode.com/problems/3sum-closest/
 * time complexity: O(n^2), space: O(1)
 * */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length == 0) return 0;
        int closest = Integer.MAX_VALUE /2;
        if(nums.length <= 3){
            int sum = 0;
            for(int i : nums){sum += i;}
            return sum;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++){
            int left = i + 1; int right = nums.length-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target) return sum;
                else if(sum < target) left++;
                else right--;
                closest = (Math.abs(sum - target) < Math.abs(closest - target)) ? sum : closest;
            }

        }
        return closest;
    }
}
