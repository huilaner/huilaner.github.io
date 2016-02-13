/**
  * difficulty: easy
  * url: https://leetcode.com/problems/happy-number/
  * tag: hashtable, math
*/
public class Solution {
    public boolean isHappy(int n) {
        if(n == 0) return false;
        if(n == 1) return true;
        HashSet<Integer> visited = new HashSet<>();
        while(n != 1 && !visited.contains(n)){
            visited.add(n);
            n = getSqSum(n);
        }
        return n ==1;
    }

    private int getSqSum(int n){
        int sum = 0;
        while(n > 9){
            int r = n%10;
            sum += r * r;
            n /= 10;
        }
        return (n > 0) ? sum+n*n : sum;
    }
}
