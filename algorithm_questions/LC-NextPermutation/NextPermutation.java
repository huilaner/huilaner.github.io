/*
 * difficulty: medium
 * url: https://leetcode.com/problems/next-permutation/
 * tag: array
 * ref: https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
 *
 *Find largest index i such that array[i − 1] < array[i].
 *Find largest index j such that j ≥ i and array[j] > array[i − 1].
 *Swap array[j] and array[i − 1].
 *Reverse the suffix starting at array[i].
*/

public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1) return;
        int i = nums.length-1, j = nums.length-1;
        while(i >0 && nums[i-1] >= nums[i]){
            i--;
        }
        if(i>0){
            while(j > 0 && nums[j] <= nums[i-1]){
                j--;
            }
            int tmp = nums[i-1];
            nums[i-1] = nums[j];
            nums[j] = tmp;
        }else i = 0;

        int k = nums.length-1;
        while(i <= k){
            int tmp = nums[i];
            nums[i] = nums[k];
            nums[k] = tmp;
            i++; k--;
        }
    }
}
