/**
  * http://www.lintcode.com/en/problem/longest-consecutive-sequence/
  * http://www.geeksforgeeks.org/longest-consecutive-subsequence/
*/
public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        if(num == null || num.length == 0) return 0;
        
        HashSet<Integer> set = new HashSet<>();
        int rst = 0;
        
        for(int n : num){
            set.add(n);
            int curr = 1;
            int left = n-1;
            int right = n+1;
            while(set.contains(left)){
                curr++;
                left--;
            }
            while(set.contains(right)){
                curr++;
                right++;
            }
            rst = Math.max(rst, curr);
        }
        
        return rst;
    }
}

//this one is faster, by as long as concluded in longest seq, it will be removed, but all should add to set at the first place
public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        if(num == null || num.length == 0) return 0;
        
        HashSet<Integer> set = new HashSet<>();
        int rst = 0;
        
        for(int n : num){
            set.add(n);
        }
        
        for(int n : num){
            int curr = 1;
            int left = n-1;
            int right = n+1;
            while(set.contains(left)){
                set.remove(left);//**
                curr++;
                left--;
            }
            while(set.contains(right)){
                set.remove(right);//**
                curr++;
                right++;
                
            }
            rst = Math.max(rst, curr);
        }
        
        return rst;
    }
}
