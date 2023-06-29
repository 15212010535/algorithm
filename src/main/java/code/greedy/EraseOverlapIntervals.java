package code.greedy;

import java.util.Arrays;

/**
 * 无重叠区间
 */
public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int remove = 0;
        int pre = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= pre) {
                pre = intervals[i][1];
            } else {
                remove++;
                pre = Math.min(pre, intervals[i][1]);
            }
        }
        return remove;
    }
}
