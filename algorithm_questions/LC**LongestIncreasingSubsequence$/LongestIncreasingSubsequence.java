/**
  * difficulty: meidum
  * url: https://leetcode.com/problems/longest-increasing-subsequence/
  * tag: DP, binary search
  **** ref: http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/ ****
*/
// time complexity: O(N^2), space: O(N)
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 0 || n == 1) return n;
        int[] L = new int[n];
        int max = 0;
        //L[j] = max(L[i]+1, for all i < j && nums[i]<nums[j]);
        Arrays.fill(L,1);
        for(int j = 1; j < n; j++){
            for(int i = 0; i < j; i++){
                L[j] = ((nums[i] < nums[j]) && (L[i]+1 > L[j])) ? (L[i]+1) : L[j];
            }
            max = Math.max(max, L[j]);
        }
        return max;
    }
}

//time complexity: O(NlogN), space: O(N)
//ref: above, and binarySearch: https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html#binarySearch(byte[],%20int,%20int,%20byte)
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 0 || n == 1) return n;
        int[] dp = new int[n];
        int max = 0;
        //keep track of the min val of a given length of subseq might ends with
        for(int x : nums){
            //binarySearch will return the index of search el, if < 0 return the position of el should be inserted into : (-(insertion point) - 1)
            int curSeqLen = Arrays.binarySearch(dp, 0, max, x);
            if(curSeqLen < 0) curSeqLen = -(curSeqLen + 1);
            dp[curSeqLen] = x;
            if(curSeqLen == max) max++;
        }
        return max;
    }
}