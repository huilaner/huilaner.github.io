/**
  * https://www.lintcode.com/en/problem/letter-combinations-of-a-phone-number/#
*/
public class Solution {
    /**
     * @param digits A digital string
     * @return all posible letter combinations
     */
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> rst = new ArrayList<>();
        if(digits == null || digits.length() == 0) return rst;
        String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        rst.add("");
        
        //iterative way
        for(int i = 0; i < digits.length(); i++){
            int size = rst.size();
            for(int j = 0; j < size; j++){
                String curr = rst.remove(0);
                int idx = digits.charAt(i) - '0';
                for(char c : map[idx].toCharArray()){
                    rst.add(curr+c);
                }    
            }
            
        }
        
        //recursive way
        //helper(rst, "", map, 0, digits);
        
        return rst;
    }
    
    private void helper(ArrayList<String> rst, String curr, String[] map, int idx, String digits){
        int n = digits.length();
        if(idx == n){
            rst.add(curr);
            return;
        }
        int num = digits.charAt(idx) - '0';
        for(char c : map[num].toCharArray()){
            helper(rst, curr+c, map, idx+1, digits);    
        }
        
    }
}
