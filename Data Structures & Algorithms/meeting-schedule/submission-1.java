/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
         if (intervals.isEmpty()) return true;
         intervals.sort((a,b)->a.start-b.start);
         Interval interval = intervals.get(0);
         for (int i=1; i<intervals.size(); ++i) {
            Interval current = intervals.get(i);
            if (interval.end > current.start) return false;
            interval = current;
         }
         return true;
    }
}
