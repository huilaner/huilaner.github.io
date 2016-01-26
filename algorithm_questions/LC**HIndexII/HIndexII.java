/**
  * difficulty: medium
  *
  * tag:
*/
//time: O(n), space:O(1)
public class Solution {
    public int hIndex(int[] citations) {
        if(citations.length == 0) return 0;
        int i = 0;
        int n = citations.length;
        while(i < n && citations[i] < (n-i)) i++;
        return n-i;
    }
}

//time: O(logN), space(1)
public class Solution {
    public int hIndex(int[] citations) {
        if(citations.length == 0) return 0;
        int i = 0;
        int n = citations.length;
        if(citations[n-1] == 0) return 0;
        if(n == 1) return 1;
        int L = 0, R = n-1;
        while(L<R){
            int M = (L+R)/2;
            if(citations[M] == n - M) return n-M;
            else if(citations[M] < n-M) L = M + 1;
            else R = M;
        }
        return n-L;
    }
}

//modified version of binary search
public class Solution {
    public int hIndex(int[] citations) {
        if(citations.length == 0) return 0;
        int i = 0;
        int n = citations.length;
        int L = 0, R = n-1;
        while(L<=R){
            int M = (L+R)/2;
            if(citations[M] == n - M) return n-M;
            else if(citations[M] < n-M) L = M + 1;
            else R = M-1;
        }
        return n-(R+1);
    }
}
