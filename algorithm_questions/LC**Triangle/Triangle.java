/**
  * difficulty: medium
  * url: https://leetcode.com/problems/triangle/
  * tag: DP
  * time: O(m*n), space: O(n)
*/
public class Solution {
    //top -> bottom
    public int minimumTotal(List<List<Integer>> triangle) {
        int numRow = triangle.size();
        if(numRow == 0) return 0;
        if(numRow == 1) return triangle.get(0).get(0);
        //since triangle, it only has one el at top
        List<Integer> dp = new LinkedList<Integer>();
        dp.add(triangle.get(0).get(0));
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < numRow; i++){
            int k = triangle.get(i).size();
            for(int j = k-1; j >= 0; j--){
                int curr = triangle.get(i).get(j);
                if(j == 0) curr += dp.get(j);
                else if(j == triangle.get(i).size()-1) curr += dp.get(j-1);
                else curr += Math.min(dp.get(j-1), dp.get(j));
                if(j != triangle.get(i).size()-1) dp.set(j,curr);
                else dp.add(curr);
                if(i == numRow -1){
                    min = Math.min(curr, min);
                }
            }

        }

        return min;

    }
}

//bottom -> top, space: O(1)
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int numRow = triangle.size();
        if(numRow == 0) return 0;
        List<Integer> dp = new LinkedList<Integer>();
        for(int i = numRow-2; i >= 0; i--){
            int k = triangle.get(i).size();
            for(int j = 0; j < k; j++){
                int curr = triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1));
                triangle.get(i).set(j, curr);
            }
        }
        return triangle.get(0).get(0);
    }
}