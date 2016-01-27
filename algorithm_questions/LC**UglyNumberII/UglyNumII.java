/**
  * difficulty: medium
  * url: https://leetcode.com/problems/ugly-number-ii/
  * tag: DP, math, heap
  * time: O(N), space: O(N)
*/
public class Solution {
    public int nthUglyNumber(int n) {
        int[] k = new int[n];
        int t2=0, t3=0, t5=0;
        k[0] = 1;
        for(int i = 1; i < n; i++){
            int l2 = k[t2]*2;
            int l3 = k[t3]*3;
            int l5 = k[t5]*5;
            k[i] = Math.min(Math.min(l2, l3), l5);
            //Be careful about the cases such as 6, in which we need to forward both pointers of 2 and 3. so not "else"
            if(k[i] == l2) t2++;
            if(k[i] == l3) t3++;
            if(k[i] == l5) t5++;
        }
        return k[n-1];
        
    }
} 