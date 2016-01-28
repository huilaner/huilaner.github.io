/**
  * difficulty: medium
  * url: https://leetcode.com/problems/kth-largest-element-in-an-array/
  * tag: divide and conquer, heap
  * time: O(NlogN), space: O(N)
  * ref: https://leetcode.com/discuss/36966/solution-explained
*/
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

// use Quick Sort partition method
// O(N) best case / O(N^2) worst case running time + O(1) memory
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if(j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }
    
    private int partition(int[] a, int lo, int hi){
        int i = lo;
        int j = hi + 1;
        while(true) {
            while(i < hi && (a[++i] < a[lo]));
            while(j > lo && (a[lo] < a[--j]));
            if(i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
    
    private void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}