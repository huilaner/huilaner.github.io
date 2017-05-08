/**
  * http://www.lintcode.com/en/problem/merge-intervals/
  *
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals, a collection of intervals
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> rst = new ArrayList<>();
        if(intervals == null || intervals.size() == 0) return rst;
        Collections.sort(intervals, new MyComparator());
        
        Interval last = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++){
            Interval itv = intervals.get(i);
            if(itv.start <= last.end){
                last.end = Math.max(last.end, itv.end);
            }else{
                rst.add(last);
                last = itv;
            }
        }
        rst.add(last);
        
        
        return rst;
        
    }

}

class MyComparator implements Comparator<Interval>{
    @Override
    public int compare(Interval o1, Interval o2){
        return o1.start - o2.start;
    }
}
