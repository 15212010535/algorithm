package nc;


import java.util.ArrayList;

/**
 * 合并区间
 */
public class MergeInterval {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // write code here
        ArrayList<Interval> res = new ArrayList<>();
        if (intervals.isEmpty())
            return res;
        intervals.sort((o1, o2) -> {
            if (o1.start != o2.start)
                return o1.start - o2.start;
            return o1.end - o2.end;
        });
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.start <= end) {
                end = Math.max(interval.end, end);
            } else {
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}
