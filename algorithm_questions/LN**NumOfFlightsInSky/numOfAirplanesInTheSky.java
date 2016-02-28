/**
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
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
        if(airplanes == null || airplanes.size() == 0){
            return 0;
        }
        //positive is start, negative is end
        int maxTime = 0;
        for(Interval time : airplanes){
            maxTime = Math.max(maxTime, time.end);
        }
        int[] timeslots = new int[maxTime+1];//waist a lof of memory
        for(Interval time : airplanes){
            timeslots[time.start] += 1;
            timeslots[time.end] -= 1;
        }
        int count = 0;
        int max = 0;
        
        //start scan timeline
        for(int k : timeslots){
            count += k;
            max = Math.max(max, count);
        }
        
        return max;
    }
}

//with Point and its comparator

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
class Point{
    public int time;
    public int flag;
    public Point(int time, int flag){
        this.time = time;
        this.flag = flag;
    }
    public static Comparator<Point> PointComparator = new Comparator<Point>(){
        public int compare(Point p1, Point p2){
           if(p1.time == p2.time) return p1.flag - p2.flag;
           else return p1.time - p2.time;
        }
    };
}

class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
        if(airplanes == null || airplanes.size() == 0){
            return 0;
        }
        //positive is start, negative is end
        int max = 0;
        ArrayList<Point> maps = new ArrayList<>(airplanes.size() * 2);
        for(Interval time : airplanes){
            Point p1 = new Point(time.start, 1);
            Point p2 = new Point(time.end, -1);
            maps.add(p1);
            maps.add(p2);
        }
        
        Collections.sort(maps, Point.PointComparator);
        
        int count =0;
        for(Point p : maps){
            count += p.flag;
            max = Math.max(max, count);
        }
        
        return max;
    }
}


