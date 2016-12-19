/*
  * https://community.topcoder.com/stat?c=problem_statement&pm=14442 
  * https://apps.topcoder.com/wiki/display/tc/SRM+702
*/
import java.util.HashSet;
public class GridSort{
    public String sort(int n, int m, int[] grid){
        for(int i = 0; i < n; i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j = 0; j < m; j++){
                set.add( (grid[i*m+j] -1) / m);
            }
            if(set.size() != 1){
                return "Impossible";
            }
            
        }

        for(int j = 0; j < m; j++){
            HashSet<Integer> set = new HashSet<>();
            for(int i = 0; i < n; i++){
                set.add( (grid[i*m+j] -1) % m);
            }
            if(set.size() != 1){
                return "Impossible";
            }
        }

        return "Possible";
    }
}
