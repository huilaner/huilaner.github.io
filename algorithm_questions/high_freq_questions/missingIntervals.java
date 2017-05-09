/**
  * http://www.lintcode.com/en/problem/missing-interval/#
*/
public class Solution {
    /**
     * @param nums a sorted integer array
     * @param lower an integer
     * @param upper an integer
     * @return a list of its missing ranges
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> rst = new ArrayList<>();
        if(nums == null || lower > upper) return rst;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == Integer.MIN_VALUE){
                lower = nums[i] + 1;
                continue;
            }
            if(lower == nums[i] - 1){
                rst.add(lower+"");
            }else if(lower < nums[i] - 1){
                rst.add(lower+"->"+(nums[i]-1));
            }
            if(nums[i] == Integer.MAX_VALUE) return rst;
            lower = nums[i] + 1;
        }
        if(lower == upper){
            rst.add(lower+"");
        }else if(lower < upper){
            rst.add(lower+"->"+upper);
        }
        
        return rst;
    }

}
