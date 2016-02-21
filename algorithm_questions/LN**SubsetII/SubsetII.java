/**
  * difficulty: medium
  * url: http://www.lintcode.com/en/problem/subsets-ii/
  * tag: recursion
*/
public class SubSetII {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (S == null || S.isEmpty()){
            return result;
        }
        
        Collections.sort(S);
        
        ArrayList<Integer> curr = new ArrayList<>();
        subsetHelper(result, curr, S, 0);
        
        return result;
    }
    
    private void subsetHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> curr,
            ArrayList<Integer> S, int start){
        result.add(new ArrayList<Integer>(curr));
        
        for (int i = start; i < S.size(); i++){
            if (i != start && S.get(i) == S.get(i-1)){
                continue;
            }
            curr.add(S.get(i));
            subsetHelper(result, curr, S, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
    
    //iterative
    public ArrayList<ArrayList<Integer>> subsetsWithDup2(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        result.add(curr);
        
        Collections.sort(S);
        
        for(int i = 0; i < S.size();){
            int count = 0;// check num of ocurrance of S[i]
            while(i+count < S.size() && S.get(i) == S.get(i+count)) count++;
            
            int prevSize = result.size();
            for(int j = 0; j < prevSize; j++){
                curr = new ArrayList<Integer>(result.get(j));
                for(int k = 0; k < count; k++){
                    curr.add(S.get(i));
                    result.add(new ArrayList<Integer>(curr));
                }
            }
            i += count; // skip duplicates, coz previous loop already add duplicates
        }
        
        return result;
    }
    
    public static void main(String[] args){
        SubSetII s = new SubSetII();
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1); al.add(2); al.add(2);
        ArrayList<ArrayList<Integer>> r = s.subsetsWithDup2(al);
        TestUtils tu = new TestUtils();
        tu.printAryAryList(r);
    }
}
