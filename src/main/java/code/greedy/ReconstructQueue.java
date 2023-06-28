package code.greedy;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 根据身高重建队列
 */
public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        LinkedList<int[]> que = new LinkedList<>();
        for (int[] p : people) {
            que.add(p[1], p);
        }
        return que.toArray(new int[people.length][]);
    }
}
