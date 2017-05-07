/**
  * http://www.lintcode.com/en/problem/system-longest-file-path/#
*/
public class Solution {
    /**
     * @param input an abstract file system
     * @return return the length of the longest absolute path to file
     */
     //can it be \t\tfile.ext\t? exact format? \t \t?
    public int lengthLongestPath(String input) {
        if(input == null || input.length() == 0) return 0;
        int max = 0;
        String[] paths = input.split("\n");   
        int n = paths.length;
        int[] sums = new int[n+2];
        
        for(int i = 1; i <= n; i++){
            String path = paths[i-1];
            path = path.replaceAll("\t", "");
            int level = paths[i-1].length() - path.length();
            sums[level+1] = sums[level] + path.length();
            if(path.indexOf(".") >= 0){
                max = Math.max(max, sums[level+1]);
            }else{
                sums[level+1]++;// dir/dir/file.txt
            }
        }

        
        return max;
    }
}
