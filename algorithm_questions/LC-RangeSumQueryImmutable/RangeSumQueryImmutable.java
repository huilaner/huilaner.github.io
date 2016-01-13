/**
  * difficulty: easy
  * url: https://leetcode.com/problems/range-sum-query-immutable/
  * tag: DP
*/
public class NumArray {
    
    private int[] dp;

    public NumArray(int[] nums) {
        this.dp = new int[nums.length];
        if(nums.length > 0){
            this.dp[0] = nums[0];
            for(int i = 1; i < nums.length; i++){
                this.dp[i] = this.dp[i-1] + nums[i];
            }
        }

    }

    public int sumRange(int i, int j) {
        return (i == 0) ? this.dp[j] : (this.dp[j] - this.dp[i-1]);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
