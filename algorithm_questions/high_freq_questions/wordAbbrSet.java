/**
  * http://www.lintcode.com/en/problem/word-abbreviation-set/#
*/
public class ValidWordAbbr {

    // @param dictionary a list of word
    HashMap<String, HashSet<String>> map = new HashMap<>();
    public ValidWordAbbr(String[] dictionary) {
        for(String w : dictionary){
            String abbr = getAbbr(w);
            HashSet<String> set;
            if(map.containsKey(abbr)){
                set = map.get(abbr);
            }else{
                set = new HashSet<>();
            }
            set.add(w);
            map.put(abbr, set);
        }
    }
    
    private String getAbbr(String w){
        int n = w.length();
        if(n < 3) return w;
        else return ""+w.charAt(0)+(n-2)+w.charAt(n-1);
    }

    /**
     * @param word a string
     * @return true if its abbreviation is unique or false
     */
    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        if(!map.containsKey(abbr)) return true;
        if(map.get(abbr).size() > 1) return false;
        for(String s : map.get(abbr)){
            return s.equals(word);
        }
        return true;
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param = obj.isUnique(word);
 */
