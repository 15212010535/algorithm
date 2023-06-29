package code.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并区间
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int start = intervals[0][0];
        int rightmostRightBound = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > rightmostRightBound) {
                res.add(new int[]{start, rightmostRightBound});
                start = intervals[i][0];
                rightmostRightBound = intervals[i][1];
            } else {
                rightmostRightBound = Math.max(rightmostRightBound, intervals[i][1]);
            }
        }
        res.add(new int[]{start, rightmostRightBound});
        return res.toArray(new int[res.size()][]);
    }
}
