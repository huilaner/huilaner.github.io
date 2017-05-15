/**
  * https://www.lintcode.com/en/problem/factorization/
  * factor - Math.sqrt(n) is the upperbound
*/
public class Solution {
    /**
     * @param n an integer
     * @return a list of combination
     */
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(n <= 1) return rst;
        List<Integer> curr = new ArrayList<>();
        helper(rst, curr, n, 2);
        return rst;
    }
    
    private void helper(List<List<Integer>>rst, List<Integer> curr, int n, int prev){
        if(n <= 1){
            if(curr.size() > 1){
                List<Integer> newCurr = new ArrayList<Integer>(curr);
                rst.add(newCurr);
            }
            return;
        }
        
        for(int i = prev; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                curr.add(i);
                helper(rst, curr, n/i, i);
                curr.remove(curr.size()-1);
            }
        }
        if(n >= prev){
            curr.add(n);
            helper(rst, curr, 1, n);
            curr.remove(curr.size()-1);
        }
    }
}
