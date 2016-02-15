/**
  * difficulty: medium
  * url: https://leetcode.com/problems/remove-duplicate-letters/
  * tag: greedy, stack
*/
public class Solution {
    public String removeDuplicateLetters(String s) {
        if(s.length() == 0) return "";
        int[] cnt = new int[26];

        for(int i = 0; i < s.length(); i++) cnt[s.charAt(i)-'a']++; // count occurance of each individual letters
        int start = 0;
        //find the start of s, if before s[i] are all duplicates and larger than s[i], just skip them and start with s[i]
        //if exist some letter only occurs once, break, coz this one cannot be skipped
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) < s.charAt(start)) start = i;
            if(--cnt[s.charAt(i)-'a'] == 0) break;
        }
        //remove all the duplicates of s[start] with start as begining of the substring
        char c = s.charAt(start);
        return s.charAt(start) + removeDuplicateLetters(s.substring(start+1).replaceAll(c+"",""));

    }
}

//stack
public class Solution {
    //the core idea is to keep the stack. and the stack is used to keep the current minimal char. 
    //if the next char is less than the top of stack ,then the top should be poped unless the top can not be poped. 
    //when can't we pop the top of stack ? the char is the last time to be seen in the raw string, then we can't pop it.
    public String removeDuplicateLetters(String s) {
        if(s.length() == 0) return "";
        int[] cnt = new int[26];
        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(char c : s.toCharArray()) cnt[c-'a']++;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            cnt[c-'a']--;
            if(visited[c-'a'] || (!stack.isEmpty() && stack.peek() == c)) continue; // to skip start letter
            while(!stack.isEmpty() && stack.peek() > c && cnt[stack.peek()-'a'] > 0){
                char p = stack.pop();
                visited[p-'a'] = false;
            }
            stack.push(c);
            visited[c-'a']=true;

        }
        
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();      

    }
}