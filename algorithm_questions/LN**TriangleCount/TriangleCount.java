/**
  * difficulty: hard
  * url: http://www.lintcode.com/en/problem/triangle-count/
  * tag: 2 pointers
*/
public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        // write your code here
        Arrays.sort(S);
        int cnt = 0;
        //find A[j]+A[k] > A[i]
        //since A[i] + any of them will be larger than the other
        for(int i = S.length-1; i >= 2; i--){
            int t = S[i];
            int j = 0, k = i-1;
            while(j <= k){
                if(S[j]+S[k] <= t) j++;
                else{
                    cnt += k-j;
                    k--;
                }
            }
        }
        return cnt;
    }
}