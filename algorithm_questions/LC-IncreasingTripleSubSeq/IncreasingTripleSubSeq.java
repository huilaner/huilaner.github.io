/**
  * difficulty: medium
  * url: https://leetcode.com/problems/increasing-triplet-subsequence
  * time: O(n), space: O(1)
*/
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false;
        int p = Integer.MAX_VALUE, q = Integer.MAX_VALUE;
        for(int n : nums){
            if(n <= p) p = n;//first min
            else if(n <= q) q = n;//second min and q > p
            else return true;// exist n that n > p and n > q
        }

        return false;
    }
}
