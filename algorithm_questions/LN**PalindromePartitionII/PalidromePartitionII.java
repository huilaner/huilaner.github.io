/**
  * difficulty: medium
  * url: http://www.lintcode.com/en/problem/palindrome-partitioning-ii/
  * tag: DP
*/
public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int n = s.length();
        boolean[][] ifPalindrome = new boolean[n][n];
        getPalindrome(s, ifPalindrome);

        
        int[] numPali = new int[n+1];
        numPali[0] = 0;
        
        for(int i = 1; i < n+1; i++){
            numPali[i] = i;
            for(int j = 0; j < i; j++){
                if(ifPalindrome[j][i-1]){
                    numPali[i] = Math.min(numPali[j]+1, numPali[i]);
                }
            }
        }
        return numPali[n]-1;
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    private void getPalindrome(String s, boolean[][] ary){
        int n = ary.length;
        for(int i = 0; i < n; i++){
            ary[i][i] = true;
            if(i != n-1) ary[i][i+1] = (s.charAt(i) == s.charAt(i+1));
        }
        // j, (j+1 ... i-1), i
        for(int len = 2; len < n; len++){
            for(int start = 0; start+len<n; start++){
                ary[start][start+len] = ary[start+1][start+len-1] && (s.charAt(start) == s.charAt(start+len));   
            }
        }

    }
};