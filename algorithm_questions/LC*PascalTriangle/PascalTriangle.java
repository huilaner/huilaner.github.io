/**
  * difficulty: easy
  * url: https://leetcode.com/problems/pascals-triangle/
  * tag: Array
  * time complexity: O(n^2), space: O(n^2)
*/
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if(numRows <= 0) return result;
        List<Integer> row = new LinkedList<Integer>();
        row.add(1);
        result.add(row);
        for(int i = 2; i < numRows+1; i++){//size of the row
            row = new LinkedList<Integer>();
            List<Integer> prev = result.get(result.size()-1);
            for(int j = 0; j < i; j++){
                if(j == 0 || j == i-1) row.add(1);
                else row.add(prev.get(j-1)+prev.get(j));
            }
            result.add(row);
        }
        return result;
    }
}
