public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        if(n <= 1) return 1;
        int[] steps = new int[2];
        steps[0] = 1;
        steps[1] = 2; // 2 ones or 1 two
        for(int i = 2; i < n; i++){
            steps[i%2] = steps[(i-1)%2] + steps[(i-2)%2];
        }
        return steps[(n-1)%2];
    }
}