/**
  * difficulty: medium
  * url: https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
  * tag: stack
  *
*/
public class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder.length() == 0) return false;
        if(preorder.length() > 1 && preorder.charAt(0) == '#') return false;
        if(preorder.charAt(preorder.length()-1) != '#') return false;
        String[] ary = preorder.split(",");
        int len = ary.length;
        int depth = 0;
        for(int i = 0; i < len-1; i++){
            if(ary[i].equals("#")){
                if(depth == 0) return false;
                else depth--;
            }
            else depth++;
        }
        return depth == 0;
    }


}



public class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder.length() == 0) return false;
        String[] ary = preorder.split(",");
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < ary.length; i++){
            while(ary[i].equals("#") && !stack.isEmpty() && stack.peek().equals("#")){
                stack.pop();
                if(stack.isEmpty()) return false;
                stack.pop();
            }
            stack.push(ary[i]);
            
            
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }


}
