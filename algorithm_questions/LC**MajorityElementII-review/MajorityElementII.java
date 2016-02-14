/**
  * difficulty: medium
  * url: https://leetcode.com/problems/majority-element-ii/
  * tag: array
  * ref1: https://leetcode.com/discuss/43248/boyer-moore-majority-vote-algorithm-and-my-elaboration
  * ref2：https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
*/
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums.length == 0) return list;
        
        int m1 = 0, m2 = 0, cnt1 = 0, cnt2 = 0;
        for(int n : nums){
            if(n == m1) cnt1++;
            else if(n == m2) cnt2++;
            else if(cnt1 == 0){
                m1 = n; cnt1 = 1;
            }
            else if(cnt2 == 0){
                m2 = n; cnt2 = 1;
            }
            else{
                cnt1--; cnt2--;
            }
        }
        cnt1 = 0; cnt2 = 0;
        for(int n : nums){
            if(m1 == n) cnt1++;
            if(m2 == n) cnt2++;
        }
        if(cnt1 > nums.length/3) list.add(m1);
        if(cnt2 > nums.length/3 && m1 != m2) list.add(m2);
        return list;
        
    }
}