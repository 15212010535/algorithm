package code.greedy;

import java.util.LinkedList;
import java.util.List;

/**
 * 划分字母区间
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new LinkedList<>();
        int[] edge = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            edge[chars[i] - 'a'] = i;
        }
        int idx = 0;
        int last = -1;
        for (int i = 0; i < chars.length; i++) {
            idx = Math.max(edge[chars[i] - 'a'], idx);
            if (i == idx) {
                list.add(i - last);
                last = i;
            }
        }
        return list;
    }
}
