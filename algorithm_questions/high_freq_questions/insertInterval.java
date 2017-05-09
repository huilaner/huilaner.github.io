/**
  * http://www.lintcode.com/en/problem/insert-interval/#
  *
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * Insert newInterval into intervals.
     * @param intervals: Sorted interval list.
     * @param newInterval: A new interval.
     * @return: A new sorted interval list.
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        
        ArrayList<Interval> result = new ArrayList<Interval>();
        if(newInterval == null) return intervals;
        
        int insertPos = 0;
        for(Interval curr : intervals){
            if(newInterval.start > curr.end){
                result.add(curr);
                insertPos++;
            }else if(newInterval.end < curr.start){
                result.add(curr);
            }else{
                newInterval.end = Math.max(newInterval.end, curr.end);
                newInterval.start = Math.min(newInterval.start, curr.start);
            }
        }
        result.add(insertPos, newInterval);
        
        return result;
    }
}
