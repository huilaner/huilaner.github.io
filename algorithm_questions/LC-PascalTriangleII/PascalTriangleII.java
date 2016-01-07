/**
  * difficulty: easy
  * url: https://leetcode.com/problems/pascals-triangle-ii/
  * tag: array
  * time complexity: O(n^2), space: O(n)
*/
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new LinkedList<Integer>();
        if(rowIndex < 0) return result;
        int prev = 1;
        result.add(1);
        for(int i = 1; i < rowIndex+2; i++){
            for(int j = 0; j < i; j++){
                if(j == 0) result.set(j, 1);
                else if(j == i-1) result.add(j, 1);
                else{
                    
                    int tmp = result.get(j);
                    result.set(j, prev+tmp);
                    //System.out.println("tmp:"+tmp+" prev:"+prev);
                    prev = tmp;
                }
            }
        }
        return result;
    }
}
