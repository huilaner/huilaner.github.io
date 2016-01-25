/**
  * difficulty: medium
  * url: https://leetcode.com/problems/h-index/
  * tag: hashtable, sort
*/
//brute force, O(N^2), O(N)
public class Solution {
    public int hIndex(int[] citations) {
        //h <=N
        int h = 0;
        if(citations.length == 0) return h;
        int n = citations.length;
        int[] stat = new int[n+1];//h from 0 - n
        for(int i = 0; i < n; i++){
            int c = citations[i];
            for(int j = 0; j <= Math.min(n,c); j++){
                stat[j]++;
            }
        }
        for(int i = n; i >= 0; i--){
            if(stat[i] >= i) return i;
        }
        return h;
    }
}

//simplify using like dp 
//time: O(N), space: O(N)
public class Solution {
    public int hIndex(int[] citations) {
        //h <=N
        int h = 0;
        if(citations.length == 0) return h;
        int n = citations.length;
        int[] stat = new int[n+1];//h from 0 - n
        for(int i = 0; i < n; i++){
            int c = citations[i];
            if(c > n) stat[n]++;
            else stat[c]++;
        }
        int t = 0;
        for(int i = n; i >= 0; i--){
            t += stat[i]; //key point
            if(t >= i) return i;
        }
        return h;
    }
}
