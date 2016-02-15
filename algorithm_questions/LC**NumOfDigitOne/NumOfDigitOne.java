/**
  * difficulty: medium
  * url: https://leetcode.com/problems/number-of-digit-one/
  * tag: math
  * ref: https://leetcode.com/problems/number-of-digit-one/
*/
public class Solution {
    public int countDigitOne(int n) {
        if(n <= 0) return 0;
        int count = 0;
        for(long k = 1; k <=n; k *= 10){
            long d = n/k, r = n%k; //long to avoid overflow
            //1. how many ones at k*10s 
            //2. how many extra ones for things like 10, 110
            //3. when 20 should include 10-19
            count += (d+8)/10*k + ( (d%10==1) ? r+1 : 0);
        }
        return count;
    }
}