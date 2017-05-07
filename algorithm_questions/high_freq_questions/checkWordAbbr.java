／**
  * http://www.lintcode.com/en/problem/check-word-abbreviation/#
  * test: "internationalization", "i12iz4n"; "a", "01"; "aa", "a2"
*／
public class Solution {
    /**
     * @param word a non-empty string
     * @param abbr an abbreviation
     * @return true if string matches with the given abbr or false
     */
     
    public boolean validWordAbbreviation(String word, String abbr) {
        if(word == null && abbr == null) return true;
        if((word == null && abbr != null) || (word != null && abbr == null)) return false;
        int m = word.length();
        int n = abbr.length();
        int i = 0, j = 0;
        while(i < m && j < n){
            char w = word.charAt(i);
            char a = abbr.charAt(j);
            if(!Character.isDigit(a)){
                if(w != a) return false;
                i++; j++;
            }else{
                String num = "";
                while(j < n &&Character.isDigit(abbr.charAt(j))){
                    num += abbr.charAt(j);
                    if(num.length() > 1 && num.startsWith("0")) return false;
                    j++;
                }
                i += Integer.parseInt(num);
            }
        }
        return (i == m && j == n);
    }
}
