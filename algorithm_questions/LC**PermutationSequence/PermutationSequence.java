/**
  * difficulty: medium
  * url: https://leetcode.com/problems/permutation-sequence/
  * tag: backtracking, math
  * ref: https://leetcode.com/discuss/42700/explain-like-im-five-java-solution-in-o-n
*/
public class Solution {
    public String getPermutation(int n, int k) {
        if(n == 0 || n == 1) return n+"";
        //get kth range
        int[] fac = new int[n+1];
        fac[0] = 1;
        fac[1] = 1;
        for(int i = 2; i <= n; i++) fac[i] = fac[i-1]*i;
        
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= n; i++) nums.add(i);
        
        k--;//nums are 0-based, k is 1-based
        for(int i = 1; i <= n; i++){
            int index = k / fac[n-i];
            // System.out.println("index:"+index);
            sb.append(nums.get(index));
            nums.remove(index);
            k -= index*fac[n-i];
        }
        
        return sb.toString();
    }
    

}