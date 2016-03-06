/**
 * difficulty: medium
 * url: http://www.lintcode.com/en/problem/number-of-islands-ii/
 * tag: union find
 *
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // Write your code here
        List<Integer> result = new ArrayList<Integer>();
        if(n == 0 || m == 0 || operators == null || operators.length == 0) return result;
        
        boolean[] visited = new boolean[m*n];
        int[] father = new int[m*n];
        
        for(int i = 0; i < m*n; i++){
            father[i] = i;
        }
        
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int [][]island = new int[n][m];
        
        int count = 0;
        for(int k = 0; k < operators.length; k++){
            Point p = operators[k];
            int idx = p.x * m + p.y;
            //bfs(visited, father, result, idx, k, m, n);
            if(island[p.x][p.y] != 1){
                island[p.x][p.y] = 1;
                count++;
                //System.out.println("count:"+count);
                visited[idx] = true;
                
                for(int i = 0; i < 4; i++){
                    if(p.x+dx[i] >= 0 && p.x+dx[i] < n && p.y+dy[i] >= 0 && p.y+dy[i] < m 
                    && island[p.x+dx[i]][p.y+dy[i]] == 1){
                        int nIdx = (p.y+dy[i])+ (p.x+dx[i])*m;
                        int f = find(father, idx);
                        int nf = find(father, nIdx);
                        if(f != nf){//if they are not from same father, need to union to decrease island number
                            count--;
                            union(father, f, nf);
                        }
                    }
                }
            }
            result.add(count);
            
        }
        return result;
    }
    

    
    private int find(int[] father, int x){
        int p = father[x];
        while(p != father[p]){
            p = father[p];
        }
        return p;
    }
    
    private void union(int[] father, int x1, int x2){
        int p1 = father[x1];
        int p2 = father[x2];
        if(p1 != p2){
            father[p1] = p2;
        }
    }
    
}