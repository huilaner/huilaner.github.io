/**
  * http://www.lintcode.com/en/problem/words-abbreviation/#
  * need to gether all the duplicate abbr and run the solution again and again
*/
public class Solution {
    /**
     * @param dict an array of n distinct non-empty strings
     * @return an array of minimal possible abbreviations for every word
     */
    public String[] wordsAbbreviation(String[] dict) {
        if(dict == null) return null;
        int n = dict.length;
        String[] rst = new String[n];
        
        ArrayList<Integer> pool = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            pool.add(i);
        }
        
        int mid = 2;
        while(!pool.isEmpty()){
            HashMap<String, HashSet<Integer>> map = new HashMap<>();
            for(int i : pool){
                String word = dict[i];
                int len = word.length();
                String abbr = (len <= mid + 1) ? word : word.substring(0, mid-1) + (len-mid) + word.charAt(len-1);
                if(map.containsKey(abbr)){
                    HashSet<Integer> set = map.get(abbr);
                    set.add(i);
                }else{
                    HashSet<Integer> set = new HashSet<>();
                    set.add(i);
                    map.put(abbr, set);
                }
            }
            
            ArrayList<Integer> nextRound = new ArrayList<>();
            for(String abbr : map.keySet()){
                HashSet<Integer> set = map.get(abbr);
                if(set.size() == 1){
                    for(int idx : set){
                        rst[idx] = abbr;    
                    }
                }else{
                    for(int idx : set){
                        nextRound.add(idx);
                    }
                }
            }
            
            pool = nextRound;
            mid++;
        }
        
        
        return rst;
    }
}
