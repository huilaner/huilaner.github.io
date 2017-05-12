
/**
  * https://www.lintcode.com/en/problem/sort-colors/
  * 典型2个指针变种 - 3个指针
  * 有点像夹逼原理： 中间指针动，如果小的就跟前面指针换，前面指针当前位置就固定了 可以++， 如果打就跟后面换，后面指针--，如果是自己的值就默默前进
*/
class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int n = nums.length;
        int left = 0, right = n - 1;
        int mid = 0;
        while(mid <= right){
            if(nums[mid] == 0){
                swap(nums, left, mid);
                left++;
                mid++;
            }else if(nums[mid] == 2){
                swap(nums, mid, right);
                right--;
            }else{
                mid++;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
