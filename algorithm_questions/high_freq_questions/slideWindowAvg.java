/**
  * http://www.lintcode.com/en/problem/sliding-window-average-from-data-stream/#
*/
public class MovingAverage {

    /** Initialize your data structure here. */
    private int size;
    private double[] prefixSum;
    private int idx;
    public MovingAverage(int size) {
        this.size = size;
        prefixSum = new double[size+1];
        this.idx = 0;
    }
    
    public double next(int val) {
        if(size <= 0) return 0.0;
        idx++;
        prefixSum[mod(idx)] = prefixSum[mod(idx-1)] + val;
        if(idx < size){
            return prefixSum[mod(idx)]/(double)idx;
        }
        double rst = prefixSum[mod(idx)] - prefixSum[mod(idx - size)];
        return rst / size;
    }
    
    private int mod(int val){
        return val % (size+1);
    }
}

public class MovingAverage2 {

    /** Initialize your data structure here. */
    private int size;
    private Queue<Integer> queue;
    private double sum;
    private int currSize;
    public MovingAverage2(int size) {
        this.size = size;
        queue = new LinkedList<>();
        sum = 0;
        currSize = 0;
    }
    
    public double next(int val) {
        if(size <= 0) return 0.0;
        currSize++;
        queue.add(val);
        if(currSize <= size){
            sum += val;
            double rst = sum / currSize;
            return rst;
        }
        int prev = queue.poll();
        sum = sum - prev + val;
        return sum / size;
        
    }
    
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param = obj.next(val);
 */
