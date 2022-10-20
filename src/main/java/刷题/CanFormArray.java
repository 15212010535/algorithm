package 刷题;

import java.util.HashMap;
import java.util.Map;

/**
 * 能否连接形成数组
 */
public class CanFormArray {
    public static boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int[] piece : pieces) {
            Integer integer = map.get(piece[0]);
            if (integer == null)
                return false;
            for (int j = 1; j < piece.length; j++) {
                integer++;
                if (integer > arr.length - 1 || piece[j] != arr[integer]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{91,4,64,78};
        int[][] pieces = new int[][]{{78}, {4,64}, {91}};
        System.out.println(canFormArray(arr, pieces));
    }
}
