/**
  * difficulty: easy
  * url: https://leetcode.com/problems/count-primes/
  * tag: hashtable??, math
  * time complexity: O(n log log n)??, space: O(n)
  * reference: https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
*/
public class Solution {
    public int countPrimes(int n) {
        int sqrt = (int)Math.sqrt(n-1);
        int[] nums = new int[n];
        if(n == 0 || n == 1) return 0;
        for(int i = 2; i <= sqrt; i++){
            for(int j = i+i; j < n; j+=i){
                if(nums[j]!= 1 && j%i == 0) nums[j] = 1;
            }
        }
        int cnt = 0;
        for(int i = 2; i < nums.length; i++){
            cnt += (nums[i] != 1) ? 1 : 0;
        }
        return cnt;
    }
}
