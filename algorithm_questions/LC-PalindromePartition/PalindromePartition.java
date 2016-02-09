/**
  * difficulty: medium
  * url: https://leetcode.com/problems/palindrome-partitioning/
  * tag: backtracking
  * ref: https://leetcode.com/discuss/18984/java-backtracking-solution
*/
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new LinkedList<List<String>>();
        if(s == "") return list;
        List<String> currList = new LinkedList<String>();
        backTrack(s, 0, currList, list);
        return list;
    }

    private void backTrack(String s, int start, List<String> currList, List<List<String>> list){
        if(currList.size() > 0 && start >= s.length()){
            List<String> newList = new LinkedList<String>(currList);
            list.add(newList);
        }
        for(int i = start; i < s.length(); i++){
            if(isPalindrome(s, start, i)){
                currList.add(s.substring(start,i+1));
                backTrack(s, i+1, currList, list);
                currList.remove(currList.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int L, int R){
        if(s == "" || L==R) return true;
        while(L <= R){
            if(s.charAt(L) != s.charAt(R)) return false;
            L++; R--;
        }
        return true;
    }
}
