/**
  * difficulty: easy
  * url: https://leetcode.com/problems/summary-ranges/
  * tag: Array
*/
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new LinkedList<String>();
        if(nums.length == 0) return list;
        
        String curr = ""+nums[0];
        
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i]-nums[i-1]==1) continue;
            else{
                if(Integer.parseInt(curr) != nums[i-1])curr += "->"+nums[i-1]; // be aware of this check to avoid 1->1 in [1,3]
                list.add(curr);
                curr = ""+nums[i];
            }
        }
        if(curr != ""){
            if(nums[nums.length-1] != Integer.parseInt(curr)) curr += "->" +nums[nums.length-1];//same here
            list.add(curr);
        }
        
        return list;
    }
}
