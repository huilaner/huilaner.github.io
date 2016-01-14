/**
  * difficulty: easy
  * url: https://leetcode.com/problems/first-bad-version/
  * tag: Binary Search
*/
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(n == 1) return 1;
        int L = 1; int R = n;
        while(L+1 < R){ //+1
            int M = L + (R-L)/2; // is not same as (L+R)/2
            if(this.isBadVersion(M)) R = M;
            else L = M;
        }
        return (this.isBadVersion(L)) ? L : R;
    }
}