//https://arena.topcoder.com/#/u/practiceCode/16836/52172/14264/1/329440
//Write the following dp: dp[i] = sum_k where k divides (i-2) dp[k] The number of good strings of length at most 150 is sum dp[i] for i from 0 to 150. 
//You can check this value is pretty small, so just generate all good strings, sort them, and check that it is a subsequence.

import java.util.*;
public class RepeatedStrings{
    public String findKth(String s, int k){
        if(s == null || s.isEmpty()) return "";
        //get all the possible combination of good strings within length of s
        int n = s.length();
        ArrayList<String> lists = new ArrayList<>();
        lists.add("()");
        for(int len = 4; len <= n; len += 2){
            for(int i = 0; i < lists.size(); i++){
                String curr = lists.get(i);
                if((len - 2) % curr.length() == 0){
                    String next = "";
                    for(int j = 0; j < (len-2)/curr.length(); j++){
                        next += curr;
                    }
                    next = "(" + next + ")";
                    //String next = "(" + new String(new char[(len-2)/curr.length()]).replace("\0", curr) + ")";
                    lists.add(next);
                }
            }
        }
        Collections.sort(lists);

        //check if combination is subseq of s and return when hit kth
        for(int i = 0; i < lists.size(); i++){
            String curr = lists.get(i);
            int idx = 0;
            for(int j = 0; j < s.length() && idx < curr.length(); j++){
                if(curr.charAt(idx) == s.charAt(j)){
                    idx++;
                }
            }
            if(idx == curr.length()){
                k--;
                if(k == 0){
                    return curr;
                }
            }
        }

        return "";
    }
}
