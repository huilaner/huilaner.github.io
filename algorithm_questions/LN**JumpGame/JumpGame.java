public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        if(A == null || A.length == 0) return true;
        
        int n = A.length;
        boolean[] canJump = new boolean[n];
        
        canJump[0] = true;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(canJump[j] && A[j]+j >= i){
                    canJump[i] = true;
                    break;
                }
            }
        }
        
        return canJump[n-1];
    }
}
