/**
  * http://www.lintcode.com/en/problem/identify-celebrity/#
*/
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    /**
     * @param n a party with n people
     * @return the celebrity's label or -1
     */
    public int findCelebrity(int n) {
        if(n <= 1) return 0;
        
        int cel = 0;
        for(int i = 1; i < n; i++){
            if(knows(cel, i)){
                cel = i;
            }
        }
        
        for(int i = 0; i < n; i++){
            if(i != cel && (knows(cel, i) || !knows(i, cel))){
                return -1;
            }
        }
        
        return cel;
    }
}
