class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 1) return 0;
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
        int[] first = intervals[0];
        int res = 0;
        for (int i = 1; i< intervals.length; ++i) {
            int[] current = intervals[i];
            if (first[1] > current[0]) {
                res++;
            } else {
                first = current;
            }    
        }
        return res;
    }
}
