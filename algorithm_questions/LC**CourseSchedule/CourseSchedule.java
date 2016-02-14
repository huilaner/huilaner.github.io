/**
  * difficulty: medium
  * url: https://leetcode.com/problems/course-schedule/
  * tag: DFS, BFS, graph, topological sort
*/
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites.length == 0) return true;
        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        
        for(int i = 0; i < prerequisites.length; i++){
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if(matrix[pre][ready] == 0) indegree[ready]++;//prevent duplicate
            matrix[pre][ready] = 1;
        }
        
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) q.offer(i); // no prereq course
        }
        
        while(!q.isEmpty()){//BFS
            int course = q.poll();
            count++;
            for(int i = 0; i < numCourses; i++){
                if(matrix[course][i] != 0){//course is the i's prereq
                    //now since we checked course, if course is the only prereq that i has, then i can be added to q
                    if(--indegree[i] == 0) q.offer(i);
                }
            }
        }
        
        return count == numCourses;
    }
}