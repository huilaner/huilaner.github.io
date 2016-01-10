/**
  * difficulty: medium
  * url: https://leetcode.com/problems/4sum/
  * tag: 2 pointers, array
  * time complexity: O(n^3)
  * note: ArrayList<> will have some tricky situation to convert to List, LinkedList might be much convenient 
*/
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if(nums.length < 4) return list;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(i != 0 && nums[i]==nums[i-1]) continue;
            else{
                for(int j = i+1; j < nums.length-2; j++){
                    if(j != i+1 && nums[j] == nums[j-1]) continue; //??
                    int left = j+1; int right = nums.length - 1;
                    while(left < right){
                        int sum = nums[i] + nums[j] + nums[left] + nums[right];
                        if(sum < target) left++;
                        else if(sum > target) right--;
                        else{
                            List<Integer> tmp = new LinkedList<>();
                            tmp.add(nums[i]); tmp.add(nums[j]);
                            tmp.add(nums[left]); tmp.add(nums[right]);
                            list.add(tmp);
                            left++; right--;
                            while(left < right && nums[left] == nums[left-1]){left++;}
                            while(left < right && nums[right] == nums[right+1]){right--;}
                        }
                    }
                }
            }
        }
        return list;
    }
}
