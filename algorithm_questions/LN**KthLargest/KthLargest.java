/**
  * difficulty: medium
  * url: http://www.lintcode.com/en/problem/kth-largest-element/
  * tag:
*/
//time: O(n), space: O(n)
class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {

        if(nums.length == 0 || k < 0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : nums) pq.add(n);
        int r = 0;
        int n = nums.length-k;
        while(n >= 0 && !pq.isEmpty()){
            r = pq.poll();
            n--;
        }
        return r;
    }
};

//quick sort
//time: O(~n), space: O(1)

class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        //review quick sort: https://en.wikipedia.org/wiki/Quicksort
        if(nums.length == 0 || k < 0) return 0;
        int lo = 0, hi = nums.length-1;
        k = nums.length - k;
        while(lo < hi){
            int p = partition(nums, lo, hi);
            if(p < k) lo = p+1;
            else if(p > k) hi = p-1;
            else break;
        }
        return nums[k];
    }
    
    /*algorithm partition(A, lo, hi) is
    pivot := A[hi]
    i := lo        // place for swapping
    for j := lo to hi - 1 do
        if A[j] ≤ pivot then
            swap A[i] with A[j]
            i := i + 1
    swap A[i] with A[hi]
    return i*/
    private int partition(int[] A, int L, int R){
        int p = A[R];
        int i = L;
        for(int j = L; j < R; j++){
            if(A[j] <= p){
                swap(A, i, j);
                i++;
            }
        }
        swap(A, i, R);
        return i;
    }
    
    private void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
};