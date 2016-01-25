/**
  * difficulty: medium
  * url: https://leetcode.com/problems/different-ways-to-add-parentheses/
  * tag: divide and conquer
  * time complexity: ?, space: O(1)
*/
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new LinkedList<Integer>();
        if(input.equals("")) return list;

        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*'){
                char c = input.charAt(i);
                String part1 = input.substring(0, i);
                String part2 = input.substring(i+1);
                List<Integer> r1 = diffWaysToCompute(part1);
                List<Integer> r2 = diffWaysToCompute(part2);
                for(int n1 : r1){
                    for(int n2 : r2){
                        if(c == '+') list.add(n1+n2);
                        else if(c == '-') list.add(n1-n2);
                        else list.add(n1*n2);
                    }
                }
            }    
        }
        if(list.size()==0) list.add(Integer.parseInt(input));
        return list;
        
    }

}