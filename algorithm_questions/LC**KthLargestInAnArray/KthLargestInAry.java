//to be added more solutions
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0) return 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int n : nums){
            if(q.size() < k) q.add(n);
            else{
                if(q.peek() > n) continue;
                else {q.remove(); q.add(n);}
            }
        }
        return q.peek();
    }
}