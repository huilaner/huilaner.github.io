/**
  * diffculty: medium
  * url: http://www.lintcode.com/en/problem/subsets/
  * tag: recursion
*/
public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.length == 0){
            return result;
        }
        ArrayList<Integer> currList = new ArrayList<>();
        
        Arrays.sort(nums);
        
        subsetHelper(result, currList, nums, 0);

        return result;
    }


    private void subsetHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> currList,
                              int[] nums, int start){
        result.add(new ArrayList<Integer>(currList));

        for (int i = start; i < nums.length; i++){
            currList.add(nums[i]);
            subsetHelper(result, currList, nums, i + 1);
            currList.remove(currList.size() - 1);
        }
    }
    
    public ArrayList<ArrayList<Integer>> subsets2(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        
        Arrays.sort(nums);
        int numSubsets = (int)Math.pow(2, nums.length);

        for (int i = 0; i < numSubsets; i++){
            result.add(new ArrayList<Integer>());
        }
        
        //jth combination, indicate if includes nums[i] on the ith bit
        //e.g. for {1,2,3} j = 3 => 0 1 1 => take 1 and 2 not 3
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < numSubsets; j++){
                if ( ((j>>i) & 1) > 0 ){
                    result.get(j).add(nums[i]);
                }
            }
        }
        
        return result;
    }
    
    public ArrayList<ArrayList<Integer>> subsets3(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        
        ArrayList<Integer> curr = new ArrayList<>();
        result.add(curr);
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++){
            int prevSize = result.size();
            for(int j = 0; j < prevSize; j++){
                curr = new ArrayList<Integer>(result.get(j));
                curr.add(nums[i]);
                result.add(new ArrayList<Integer>(curr));
            }

        }
        
        return result;
    }
    
    public static void main(String[] args){
        Subsets s = new Subsets();
        int[] ary = {4,1,0};
        ArrayList<ArrayList<Integer>> r = s.subsets3(ary);
        TestUtils tu = new TestUtils();
        tu.printAryAryList(r);
    }
}
