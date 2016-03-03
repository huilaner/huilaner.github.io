/**
  * difficulty: medium
  * url: https://leetcode.com/problems/course-schedule-ii/
  * tag: DFS, BFS, graph, topological sort
*/
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];

        HashMap<Integer, HashSet<Integer>> requirements = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            requirements.put(i, new HashSet<Integer>());
        } 
        for(int[] p : prerequisites){
            int ready = p[0];
            int pre = p[1];
            if(!requirements.get(pre).contains(ready)){
                indegree[ready]++;
            }
            requirements.get(pre).add(ready);
        }

        int idx = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
                result[idx] = i;
                idx++;
            }
        }

        while(!q.isEmpty()){
            int currCourse = q.poll();
            HashSet<Integer> followingCourses = requirements.get(currCourse);
            for(int i : followingCourses){
                indegree[i]--;
                if(indegree[i] == 0){
                    q.offer(i);
                    result[idx] = i;
                    idx++;
                }
            }
        }

        if(idx != numCourses){
            result = new int[0];
        }

        return result;

    }

}
