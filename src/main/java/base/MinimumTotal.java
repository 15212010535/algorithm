package base;

import java.util.Arrays;
import java.util.List;

/**
 * 三角形最小路径和
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] minLen = new int[size + 1];
        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                minLen[j] = Math.min(minLen[j], minLen[j + 1]) + triangle.get(i).get(j);
            }
            System.out.println(Arrays.toString(minLen));
        }
        return minLen[0];
    }
}
