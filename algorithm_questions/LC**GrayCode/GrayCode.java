/**
  * difficulty: medium
  * url: https://leetcode.com/problems/gray-code/
  * tag: backtracking
*/
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new LinkedList<Integer>();
        list.add(0); 
        if(n <= 0) return list;
        //n = 1
        list.add(1);
        int k = 1;
        while(k < n){
            for(int i = list.size()-1; i >= 0; i--){
                list.add(list.get(i)+(1<<k));
            }
            k++;
        }
        return list;
    }
    

}
