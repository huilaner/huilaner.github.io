/**
  * difficulty: easy
  * url: https://leetcode.com/problems/rotate-array/
  * tag: Array
  * time complexity: O(n), space: O(1)
*/
public class Solution {
    /**
     * 1. Divide the array two parts: 1,2,3,4 and 5, 6
     * 2. Rotate first part: 4,3,2,1,5,6
     * 3. Rotate second part: 4,3,2,1,6,5
     * 4. Rotate the whole array: 5,6,1,2,3,4
    */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if(n == 0 || k == 0 || n <= k) return;
        
        reverseAry(nums, 0, n-k-1);
        reverseAry(nums, n-k, n-1);
        reverseAry(nums, 0, n-1);
    }
    
    public void reverseAry(int[] ary, int L, int R){
        while(L<R){//good way to reverse ary!!
            int tmp = ary[L];
            ary[L] = ary[R];
            ary[R] = tmp;
            L++;
            R--;
        }
    }
    
}
