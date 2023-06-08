package base;

import java.util.Arrays;

public class Merge {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length ==0)
            throw new IllegalArgumentException("array is null or array is empty");
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[index][1] < intervals[i][0]) // 后移
                intervals[++index] = intervals[i];
            else { // 合并
                intervals[index][1] = Math.max(intervals[index][1], intervals[i][1]);
            }
        }
        return Arrays.copyOf(intervals, index + 1);
    }
}
