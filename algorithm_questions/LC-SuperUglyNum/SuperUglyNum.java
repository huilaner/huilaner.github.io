/**
  * difficulty: medium
  * url: https://leetcode.com/problems/super-ugly-number/
  * tag: math, heap
  * time: O(n*k), space: O(n)+O(k)
*/
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] L = new int[n];
        int k = primes.length;
        int[] idx = new int[k];
        L[0]=1;
        for(int i = 1; i < n; i++){
            L[i] = Integer.MAX_VALUE;
            int minIdx = 0;

            for(int j = 0; j < k; j++){
                L[i] = Math.min(L[i], primes[j]*L[idx[j]]);
            }
            //cannot merge this two, coz more than one idx[j] might +1, e.g. 6
            for(int j = 0; j < k; j++){
                if(L[i] == primes[j]*L[idx[j]]) idx[j]++;
            }

        }
        
        return L[n-1];
    }
}
